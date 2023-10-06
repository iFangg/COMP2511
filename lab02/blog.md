### Hotel exercise
## Task 1 responses
Q1: Why is this approach considered good design? What principles does it makes use of?
This approach of using an ADT is considered good design because it removes unnecessary cluster in your code, keeping functions concise and abstacting helper functions to make sure the code is clean and readable. If we have a look at the booking system and the different modules and classes contained within the system, java makes it quite easy to encapsulate all necessary attributes in their respective classes and prevent overflow into other areas.

Q2: What is meant by the term "black-box"? How are the tests inside BookingSystemTest black-box?
A black-box test is where program is tested with hand-written expected values because the tester does not have any knowledge of the code's functionality or interior workings. All the tests care about are if the outputs of the program match what the user expects. 

## Task 2 responses
Q3: What does this method do? What does it return, and what side effects does it have?

The makeBooking method checks the hotel for available rooms, returns a boolean value based on if there ae available rooms to book. Availability checks for if it's a valid room or not, and the method then attempts to book a room in the given timeframe - a booking objet will be made if successfully booked. The object being created can be considered a side affect of this method, as an object is being created despite the method returning a boolean value.

Q4: In your opinion, which is better quality code, Code A or B? Justify your answer.
Code A is better quality code because the add method is only used where necessary. Observing code B, the add method unnecessarily copied and pasted three times making the code messier. Code A is better because it follows the KISS (Keep It Simple, Stupid) and DRY (Don't repeat yourself) design principles and maintains the simplicity and readability of the code.

## Task 3 responses
Q5: What are some code smells (features of the code that make it poor quality) present in this method?
Some code smells of this method include: Nested if/else statements within more if/else statements - just to return a boolean value - and several return statements returning similar boolean statements. The multiple boolean return statements makes the code verbose and contains unncessary return statements when the code could be more concise.

## Task 4 responses
Q6: Note down all of the code smells you can see.
All three of the interfaces use the same "Book" method to book a room. This disobeys the DRY design principle because a single method or separate interface could have been implemented to avoid repeating code. The interfaces are almost the exact same except for the welcome message, which is an easy fix - the welcome messages can be put into an array and individually retrieved depending on the type of room booked, although isn't a necessary fix compared to the repeated book method.

Q7: Reflect on your thought process, the steps you took to refactor and how you have improved the design of the system.
My thought process followed the design principles and helped improve the code's redability and efficiency. Though the idea concerning the strings wasn't entirely necessary, it was an extra step that could be applicable later on when more roomTypes are implemented. To refactor the code, I changed the Room interface to an abstract class so that I could extract the book method from the different room classes. By extracting the method, each room class no longer needs to have identical code and they now follow our design principles.

## Reflections
The activity was a great reminder to take a break when you hit a mental roadblock with a problem. The length of this exercise also tested my ability to focus and continually solve problems for an extended period of time.
