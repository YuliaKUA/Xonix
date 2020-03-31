# Xonix
Classic computer game written in Java, using swing and awt libraries for graphics.

There are 2 types of surface in the game: conditionally “land” and “sea”. 
A player-controlled cursor and program-controlled points move across the field. 
The cursor can move vertically and horizontally, points - diagonally. 
Points can be “land” and “sea”, that is, they move either only on “land” or only on “sea”, bouncing off the border separating them.

The game is considered lost if the cursor hits a “land” or “sea” point, if the cursor crosses the “sea” point, 
or when trying to “reverse” the direction of movement in the “sea” or stop. 
As soon as the cursor is again on the “land”, its track turns into a new “land”. 
If at the same time a closed region without dots appeared in the “sea”, then this entire region also turns into “land”.

##### Update soon

Planned to implement: menu option section

### Program operation example
![Image alt](https://github.com/YuliaKUA/Xonix/blob/master/image/gif.gif)
