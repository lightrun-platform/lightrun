import random
import time

def fillArray():
    arr = []
    for i in range(10):
        arr.append(random.randint(1, 100))
    return arr

def sortArray(arr):
    swaps = 0
    for i in range(len(arr)):
        for j in range(len(arr)-1):
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]
                swaps = swaps + 1
    return arr

def main():
    try:

        import lightrun # this would generally be together with other imports at the top of the file
        lightrun.enable(
            company_key='xxxxx-xxxxx-xxxxx-xxxxx-xxxxx') 
    except ImportError as e:
        print("Error importing Lightrun: ", e)

    while True:
        arr = fillArray()
        print("Original array:", arr)
        arr = sortArray(arr)
        print("Sorted array:", arr)
        time.sleep(1)

if __name__ == "__main__":
    main()
