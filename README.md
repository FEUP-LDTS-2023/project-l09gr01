## LDTS_l09gr01 - Bad Ice


In this fun and exciting strategy, maze-based game, your goal is to collect every last piece of fruit in each level. 
Each maze is guarded by different monsters that you can either defeat or avoid by using different power-ups that are scattered around the area.
You will be able to modify the maze layout in real time to your advantage by destroying and creating ice blocks.
Your creativity and ability to think quick will be put to the test!

This project is being developed by João Parada (up201405280@edu.fe.up.pt), João Cordeiro (up202205682@edu.fe.up.pt) and Luciano Ferreira (up202208158@edu.fe.up.pt) for LDTS 2023⁄24.

### IMPLEMENTED FEATURES

- WIP;

### PLANNED FEATURES

- **Arena levels** - For each level there will be different arena layouts with increasing difficulty.
![mockup-2](https://github.com/FEUP-LDTS-2023/project-l09gr01/assets/117671595/c48fd691-5ec7-4896-8b7d-f56fa4228431)
Level example

- **Power-ups** - You can collect different power-ups from the ground that will boost your character (faster movement speed, temporary immunity, etc.) or give you access to new abilities.
- **Breaking walls** - You have the ability to break rows or lines of walls by pressing spacebar as long as you are facing them and they are breakable.
- **Creating walls** - You have the ability to create rows or lines of walls by pressing spacebar as long as there is room avaiable.
- **Two-player mode**
- **Different difficulty monster behaviour algorithms**
- **Menus and Hiscores functionality**
![mockup-1](https://github.com/FEUP-LDTS-2023/project-l09gr01/assets/117671595/f9d1b2b4-1731-47b6-91be-e73b43955e61)
![mockup-3](https://github.com/FEUP-LDTS-2023/project-l09gr01/assets/117671595/f604b506-c9a0-4de2-b7cf-083d9d60dbf1)
- **Saving and loading level unlocks** 
- **Score updater** - For each fruit collected the score increases. (see level example)
- **Pausing game state** - Pressing P or ESC during game, the current game state will freeze until it is resumed or closed. (see level example)
- **Game sound** - Getting hit by a monster, collecting fruit, hitting a wall, collecting and using power-ups, completing level, losing level all should play different sounds.
- **Music** - Menu music and in-game music.

### DESIGN

**Problem in Context**
Creating menus


**The Pattern**
MVC Architectural Pattern


**Implementation**
For each new menu there will be a new state, viewer and controller.


### SELF-EVALUATION
João Parada - 50%,
João Cordeiro - 25%,
Luciano Ferreira - 25%.

