import random

print("Hello, world!")
num = random.randint(1, 100)
guesses = 0
while True:
    guess = int(input("Enter your guess: "))
    guesses += 1
    if guess < num:
        print("Too low")
    elif guess > num:
        print("Too high")
    else:
        print("You win!")
        break

print(f"You took {guesses} guess")
