# Jetbrains Academy - Cinema Room Manager

My solutions for the Jetbrains Academy Problem Cinema Room Manager

https://hyperskill.org/projects/138

The solution is build up step by step over several stages. 
Stage 1 is the first and simple one. The following stages 
build up on the previous stages and get more and more advanced.
There are five stages in total.

Because each stage is completely independent of the previous one,
IntelliJ might show some warnings about duplicated code between 
the stages.

## Stage 1/5

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/138/stages/735/implement)

Just some basic output of the seating arrangement.

just execute this:

    gradle -PmainClass=stage1.MainKt run --console=plain

    Cinema:
    1 2 3 4 5 6 7 8
    1 S S S S S S S S
    2 S S S S S S S S
    3 S S S S S S S S
    4 S S S S S S S S
    5 S S S S S S S S
    6 S S S S S S S S
    7 S S S S S S S S

## Stage 2/5

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/138/stages/736/implement)

Basic profit calculation.

just execute this:

    gradle -PmainClass=stage2.MainKt run --console=plain

    Enter the number of rows:
    13
    Enter the number of seats in each row:
    23
    Total income:
    $2668

## Stage 3/5

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/138/stages/737/implement)

Here we can create a new floor plan and book a single seat. The booked seat is marked in the plan with a "B".

just execute this:

    gradle -PmainClass=stage3.MainKt run --console=plain
    
    Enter the number of rows:
    6
    Enter the number of seats in each row:
    9
    Cinema:
      1 2 3 4 5 6 7 8 9
    1 S S S S S S S S S
    2 S S S S S S S S S
    3 S S S S S S S S S
    4 S S S S S S S S S
    5 S S S S S S S S S
    6 S S S S S S S S S
    Enter a row number:
    3
    Enter a seat number in that row:
    1
    Ticket price: $10
    Cinema:
      1 2 3 4 5 6 7 8 9
    1 S S S S S S S S S
    2 S S S S S S S S S
    3 B S S S S S S S S
    4 S S S S S S S S S
    5 S S S S S S S S S
    6 S S S S S S S S S

## Stage 4/5

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/138/stages/738/implement)

Here we add a menu and a loop, so we can book multiple seats.

just execute this:

    gradle -PmainClass=stage4.MainKt run --console=plain
    
    Enter the number of rows:
    3
    Enter the number of seats in each row:
    7
    
    1. Show the seats
    2. Buy a ticket
    0. Exit
    1
    Cinema:
      1 2 3 4 5 6 7
    1 S S S S S S S
    2 S S S S S S S
    3 S S S S S S S
    
    1. Show the seats
    2. Buy a ticket
    0. Exit
    2
    Enter a row number:
    2
    Enter a seat number in that row:
    1
    Ticket price: $10
    Cinema:
      1 2 3 4 5 6 7
    1 S S S S S S S
    2 B S S S S S S
    3 S S S S S S S
    
    1. Show the seats
    2. Buy a ticket
    0. Exit
    2
    Enter a row number:
    3
    Enter a seat number in that row:
    5
    Ticket price: $10
    Cinema:
      1 2 3 4 5 6 7
    1 S S S S S S S
    2 B S S S S S S
    3 S S S S B S S
    
    1. Show the seats
    2. Buy a ticket
    0. Exit
    1
    Cinema:
      1 2 3 4 5 6 7
    1 S S S S S S S
    2 B S S S S S S
    3 S S S S B S S
    
    1. Show the seats
    2. Buy a ticket
    0. Exit
    0    

## Stage 5/5

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/138/stages/739/implement)

Here we add an option to calculate and show some statistics.

just execute this:

    gradle -PmainClass=stage5.MainKt run --console=plain
    
    output is too long and too awesome to show here ...