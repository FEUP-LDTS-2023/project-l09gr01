## LDTS_l09gr01 - Bad Ice


In this fun and exciting strategy, maze-based game, your goal is to collect every last piece of fruit in each level. 
Each maze is guarded by different monsters that you can either defeat or avoid by using different power-ups that are scattered around the area.
You will be able to modify the maze layout in real time to your advantage by destroying and creating ice blocks.
Your creativity and ability to think quick will be put to the test!

This project is being developed by João Parada (up201405280@edu.fe.up.pt), João Cordeiro (up202205682@edu.fe.up.pt) and Luciano Ferreira (up202208158@edu.fe.up.pt) for LDTS 2023⁄24.

### IMPLEMENTED FEATURES

> This section should contain a list of implemented features and their descriptions. In the end of the section, include two or three screenshots that illustrate the most important features.

**Examples**:

- WIP;

### PLANNED FEATURES

> This section is similar to the previous one but should list the features that are not yet implemented. Instead of screenshots you should include GUI mock-ups for the planned features.
- **Arena levels** - For each level there will be different arena layouts with increasing difficulty.
![docs/mockups/Screencast from 22-12-2023 11 50 57_trimmed.gif](https://github.com/FEUP-LDTS-2023/project-l09gr01/blob/master/docs/mockups/Screencast%20from%2022-12-2023%2011%2050%2057_trimmed.gif)
![docs/mockups/Screencast from 22-12-2023 11 49 24.gif](https://github.com/FEUP-LDTS-2023/project-l09gr01/blob/master/docs/mockups/Screencast%20from%2022-12-2023%2011%2049%2024.gif)
Level example

- **Power-ups** - You can collect different power-ups from the ground that will boost your character (faster movement speed, temporary immunity, etc.) or give you access to new abilities.
- **Breaking walls** - You have the ability to break rows or lines of walls by pressing spacebar as long as you are facing them and they are breakable.
- **Creating walls** - You have the ability to create rows or lines of walls by pressing spacebar as long as there is room avaiable.
- **Two-player mode**
- **Different difficulty monster behaviour algorithms**
- **Menus and Hiscores functionality**
![docs/mockups/Screencast from 22-12-2023 11 49 24.gif](https://github.com/FEUP-LDTS-2023/project-l09gr01/blob/master/docs/mockups/Screencast%20from%2022-12-2023%2011%2055%2010.gif)
- **Saving and loading level unlocks** 
- **Score updater** - For each fruit collected the score increases. (see level example)
- **Pausing game state** - Pressing P or ESC during game, the current game state will freeze until it is resumed or closed. (see level example)
- **Game sound** - Getting hit by a monster, collecting fruit, hitting a wall, collecting and using power-ups, completing level, losing level all should play different sounds.
- **Music** - Menu music and in-game music.

### DESIGN

> This section should be organized in different subsections, each describing a different design problem that you had to solve during the project. Each subsection should be organized in four different parts:



**Problem in Context**
Creating menus


**The Pattern**
MVC Architectural Pattern


**Implementation**
For each new menu there will be a new state, viewer and controller.


#### KNOWN CODE SMELLS

> This section should describe 3 to 5 different code smells that you have identified in your current implementation.

### TESTING


### SELF-EVALUATION

> In this section describe how the work regarding the project was divided between the students. In the event that members of the group do not agree on a work distribution, the group should send an email to the teacher explaining the disagreement.


