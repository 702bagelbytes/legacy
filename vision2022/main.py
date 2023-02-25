import cv2
import numpy as np

import sys
from fractions import Fraction

DEBUG = 1
CHECKS = 1
# 80 = more false positives like faces, 120 = doesn't recognize far away cargo
MIN_SAT = 80
MIN_VAL = 100


def hue_range(hsvImg, minHue, maxHue):
    return cv2.inRange(hsvImg, (minHue, MIN_SAT, MIN_VAL), (maxHue, 255, 255))

def mask_yellow(hsvImg):
    return hue_range(hsvImg, 17, 35)


def process(masked, draw, color):
    # open to remove noise (erode, then dilate)
    # kernel = cv2.getStructuringElement(cv2.MORPH_RECT, (7, 7))
    # eroded = cv2.erode(masked, kernel, iterations=1)
    # opened = cv2.dilate(eroded, kernel, iterations=2)

    contours, _ = cv2.findContours(masked, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)
    print(color)
    for i, c in enumerate(contours):
        (x, y), radius = cv2.minEnclosingCircle(c)
        # filter out really small objects
        if radius < 10: # and CHECKS:
            continue
        # filter out non-round objects
        rx, ry, w, h = cv2.boundingRect(c)
        fullness = cv2.contourArea(c) / (w * h)
        # balls have fullness around .5,
        #  but far in the distance balls can be lower
        if fullness < 0.5 and CHECKS:
            continue

        aspectRatio = w / h
        # balls usually have aspect ratio >1 (they're round)
        if aspectRatio < 0.85 and CHECKS:
            continue

        cv2.circle(draw, (int(x), int(y)), int(radius), color, 3)
        if DEBUG:
            print(i, fullness, aspectRatio, radius)
            cv2.rectangle(draw, (rx, ry), (rx + w, ry + h), color, 3)
            cv2.putText(
                draw,
                str(i),
                (int(x), int(y)),
                cv2.FONT_HERSHEY_SIMPLEX,
                1,
                (0, 0, 0),
                3,
            )
    # cnts = cv2.drawContours(draw, contours, -1, (0, 255, 0), 3)
    return draw


def proc_img(frame):
    # resize
    h, w, _ = frame.shape
    scale = 600 / float(w)
    width = int(scale * w)
    height = int(scale * h)
    print("resize:", (w, h), (width, height))
    frame = cv2.resize(frame, (width, height), interpolation=cv2.INTER_AREA)
    blurred = cv2.GaussianBlur(frame, (11, 11), 0)

    hsv = cv2.cvtColor(blurred, cv2.COLOR_BGR2HSV)
    draw = frame.copy()

    """
    b = mask_blue(hsv)
    if DEBUG:
        cv2.imshow("blue", b)
    process(b, draw, (255, 0, 0))

    r = mask_red(hsv)
    if DEBUG:
        cv2.imshow("red", r)
    process(r, draw, (0, 0, 255))
    """
    y = mask_yellow(hsv)
    if DEBUG:
        cv2.imshow("yellow", y)
    process(y, draw, (0, 255, 0))

    cv2.imshow("Result", draw)


def proc_video(cap, speed_mult):
    # img = cv2.imread("field.png")
    i = 0
    while cap.isOpened():
        ret, frame = cap.read()
        if not ret:
            break

        i = (i + 1) % speed_mult
        if i != 0:
            continue

        proc_img(frame)

        if cv2.waitKey(15) & 0xFF == ord("q"):
            break

    cap.release()


if "i" in sys.argv:
    proc_img(cv2.imread(sys.argv[2]))
    cv2.waitKey(0)
elif "v" in sys.argv:
    proc_video(cv2.VideoCapture("the_hub.webm"), 20)
else:
    cap = cv2.VideoCapture(1)
    proc_video(cap, 1)
    cap.release()

cv2.destroyAllWindows()
