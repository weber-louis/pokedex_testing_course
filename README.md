![Homepage](homepage.png)

![Pokedex](pokedex.png)

![Individual Pokemon Page](pokemon.png)

![Battle](battle.png)

# _Pokedex_

#### _A Java web app that stores the original 151 Pokemon in the Pokedex (using SQL database) along with their moves which are used in a separate battle mode game._

#### Original game by _**Peter Beach, Adam Craig, Ashley Maceli and Kyle Wolfson**_

## DISCLAIMER

_We do not own the images used in this web app._
_We own no copyrighted or trademarked material herein._
_All rights belong to their respective owners._

## Description

_A Java web app that stores the original 151 Pokemon in the Pokedex (using SQL database) along with their moves which are used in a separate battle mode game. In the Pokedex, can view all Pokemon and view their individual pages for more details. In the Pokedex, the user can filter Pokemon based on name, move, type and ideal enemies to fight. In the battle mode game, players choose one of the 151 Pokemon and use their moves with various power and accuracy levels. Pokemon and Moves have a many-to-many relationship in the SQL database._

##Database Tables

![Database](sqldesigner.png)

## Setup/Installation Requirements

* _SETTING UP THE DATABASE AND TEST DATABASE_
* _Clone repository to desktop_
* _Use console to enter directory with all files_
* _In a new console window run the command 'postgres' and keep running_
* _In a new console window run the command 'psql -U postgres' then 'CREATE DATABASE pokedex;'_
* _In the same console window run the command 'psql -U postgres' then 'CREATE DATABASE pokedex_test;'_
* _In bash console run the command 'psql -U postgres pokedex < pokedex.sql' to properly download the database file into the empty database you just created_
* _In the same bash console run the command 'psql -U postgres pokedex_test < pokedex.sql' to properly download the database file into the empty database you just created_
* _(Alternative to downloading test database file: Run the command '\c pokedex' to connect to the database. To create the test database run the command 'CREATE DATABASE pokedex_test WITH TEMPLATE pokedex;')_
* _RUNNING THE WEB APP_
* _In console run the command 'gradle run'_
* _Open your browser and go to http://localhost:4567/_

## Technologies Used

_Java, SQL, Spark, Velocity, HTML, CSS, JavaScript, Gradle, JUnit, FluentLenium_

### License

The MIT License (MIT)

Copyright (c) 2016 Peter Beach, Adam Craig, Ashley Maceli, Kyle Wolfson
Copyright (c) 2020 Salah Ghamizi

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
