# App Test
## This is a app for testing assignment.

## Moon Rovers

NASA recently found a new deep square shaped crater at the other side of the moon. We are tasked to develop a rover simulation application to navigate and explore this newly found crater. To simplify navigation in this crater, NASA divided the crater into a grids of x and y coordinate system starting from 0,0 (bottom-left / south-west) to 5,5 (top-right / north-east). This crater is deep enough so that once the rover lands inside the crater, it won't be able to go out anymore.

Positioning system will be represented by 3 characters which is a combination of an x and y coordinates and a letter representing one of the four cardinal compass points initial (North/East/West/South). Rover should be able to accept a simple string of letters as navigation instructions. The possible letters are ‘L’, ‘R’ and ‘M’. ‘L’ and ‘R’ makes the rover spin 90 degrees Left or Right respectively, without moving from its current spot. ‘M’ means Move forward one grid point, and maintain the same heading.

Build an application that can simulate this rover behaviour, application will accept 2 different text input and will produce 1 final coordinate and heading output.

## Input:
The first input is the coordinate where the rover going to land and it’s heading.
And the second input is a series of instructions telling the rover how to explore and move around the crater.

## Output:
The output should be its final co-ordinates and heading.

## Test Case 1:
Location: 12N
Movement: LMLMLMLMM
Output: 13N

## Test Case 2:
Location: 33E
Movement: MMRMMRMRRM
Output: 51E

## Test Case 3:
Location: 55N
Movement: MMRMMLLMRMLLM
Output: 44S

## Requirements
Java: 11
Kotlin: 1.8.0
Android Studio: Electric Eel | 2022.1.1 Patch 2