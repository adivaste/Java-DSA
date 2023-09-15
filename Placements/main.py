import ast
import textwrap

text = """Sure, here's a Java code snippet to reverse an array in a prettier format:\n\n```java\nimport java.util.Arrays;\n\npublic class ReverseArray {\n    public static void main(String[] args) {\n        int[] originalArray = {1, 2, 3, 4, 5};\n        \n        // Print the original array\n        System.out.println("Array: " + Arrays.toString(originalArray));\n        \n        // Reverse the array\n        int[] reversedArray = reverse(originalArray);\n        \n        // Print the reversed array\n        System.out.println("Reversed Array: " + Arrays.toString(reversedArray));\n    }\n    \n    public static int[] reverse(int[] arr) {\n        int[] reversed = new int[arr.length];\n        int lastIndex = arr.length - 1;\n        \n        for (int i = 0; i < arr.length; i++) {\n            reversed[i] = arr[lastIndex - i];\n        }\n        \n        return reversed;\n    }\n}\n```\n\nThis code defines a `reverse` method that takes an array as input and returns a new array with its elements in reverse order. It then demonstrates how to use this method to reverse an array and prints both the original and reversed arrays."""

# Remove escape characters from the text
formatted_text = ast.literal_eval(f'"{text.strip()}"')

# Set the desired line width for wrapping
# line_width = 80

# # Wrap the text to the specified line width
# wrapped_text = textwrap.fill(formatted_text, width=line_width)

# Print the formatted text
print(formatted_text)
