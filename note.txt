In web development, string interpolation is one of the most commonly used string manipulations.



Although many programing languages provide build-in string interpolation support, in this challenge you need implement it by yourself. It's not allowed to use the build-in string interpolation mechanism in the programming language you choose.



In this challenge, the variable names are denoted by double curly braces: {{ and }}. For example, given string "Your name is {{ name }}" and key-value pair object { "name": "Johnny" }, it should return "Your name is Johnny".



Spaces/tabs between double curly braces and the variable names are ignored. For example, "My name is {{ name }}", "My name is {{name}}" and "My name is {{ name}}" are equivalent.



Your Task



Please implement a function/method that takes 2 parameters:

  A string that the interpolation will be applied to. This parameter is required.
  A key-value pair object (choose the key-value pair type supported by the language you choose) with string keys and any type of values. This parameter is required.
The function/method should:

  Return the string after interpolation
  Ignore the key-value pair object keys that are not present in the variable in the string
  Throw exception/error if one of the variables in the string is missing from the key-value pair object
Here are some test cases that can help you understand the requirements better.



Test Case 1

Given the following parameters:

- content: "My name is {{ name }} and I am forever {{ age }}."

- values: { "name": "Bill", "age": 21 } (This is a JSON representation just for the purpose of demonstrating the test case, but you should choose the key-value pair object type supported by the language you choose)

Your function/method should return "My name is Bill and I am forever 21.".



Test Case 2

Given the following parameters:

- content: "Say hello to {{ name }}. He is {{ age }}."

- values: { "name": "Bill", "age": 21, "male": true} (This is a JSON representation just for the purpose of demonstrating the test case, but you should choose the key-value pair object type supported by the language you choose)

Your function/method should return "Say hello to Bill. He is 21.". You can see that the key "male" is ignored because it's not one of the variables in the content.



Test Case 3

Given the following parameters:

- content: "Tommy is a good friend of {{ name }}. He lives in {{ city }}."

- values: { "name": "Bill" } (This is a JSON representation just for the purpose of demonstrating the test case, but you should choose the key-value pair object type supported by the language you choose)

Your function/method should throw exception/error because the variable "city" is missing from the keys of the values object.