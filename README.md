BlackJack
=========

AP Computer Science BlackJack Program


##Relection:

* 1.) Shockingly 70% of my UML was used in the final project and covered the "core" of the class methods. Some methods and ArrayLists could not have been forseen, such as Values and Ranks in the Hand class. I needed to creat those to handle logical checking in Player and Dealer for BlackJack. I think that the UML was a massive help because it gave me the core stucture of the classes so I didn't have to completely recreate the classess because the methods conflicted. I kept all of the get"____"() methods and most of the set() methods because those things will always be needed regardless of the structure of the code.


* 2.) I had a really good time programming this game, it tested me in a way that I didn't think to be tested: to be creative and function while operating in a set boudnry. I found it challenging in a macro sense because in order to make the program work properly, I had to think on multiple Class levels and handle dozens of variables and conditions between methods. I found it very enjoyable and I like the progject that have to do with a fully complete idea, such as a BlackJack game. I felt that I went above and beyond in creating the Hand and Card classes because I think that my approach to handling the values for each card was done very well. I thought that storing the Hand's Values and Ranks in serperate ArrayLists was a good idea and made the checking for certain scenerios much easier. In hindsight, I would have extended Hand to Player because the current method I have makes the inter-Hand calling and checking a major pain because I have to go through the Hand object first


Finally, I think that my program earned an A through style and efficieny but not through fucntionality. The game only works 60% of the time and the biggest issue is that some of the data breaks the checking methods and doens't resolve a hand to a win or loss. I think that the way I created the classes and prosessed rules was excellent but I coudln't tie it together in the end.




##Introduction

BlackJack is a simple Java program for an AP Computer Science class.The program is a playable game of BlackJack in which there is a dealer, player, and deck. The basic Heirarchy of the program follows BlackJack Play. 

Game Rules > Dealer > Player > Shoe > Deck > Hand > Card

Implementation of a GUI is a goal once the basic console game is finished.


##Card:

The Card class is the basis of the entire program. When a card is created two integers and passes into the constructor which determine the Rank and Suit of the card (ex. Jack of Spades). Based on the Rank, a numerical vlaue "value" is assigned to the card which will be used later to calculate Hand totals.

The Card class has methods to retrive important variables as well as a setAce() method which changes the value of an Ace from 11 to 1 (from the rules of BlackJack). Card, along with almost every other class, Card contains a toString() method which overrides the default one and organizes the information.

##Deck:

A deck is a collection of 52 card in which there are 13 different ranks and 4 suits per rank. The deck is created by iteration over the number of Ranks and Suits to get 52. The constructor uses a private ArrayList of Cards and fills it with the its iteration over the total number of cards.

In retrospect, Deck is useless in comparison to Shoe as Shoe has to be an ArrayList of Cards as well, therefore a massive deck. Shoe does a better function job being an ArrayList of Cards rather than Decks because it is easier to access the shoe's cards that way.

##Shoe: 

The shoe is a large deck which contain a minimum number of decks which is multiplied by 52 to get the total number of cards in the shoe. The show can deal cars and shuffle card if the dealer requires it. The show constructor takes an integer of the number of decks.

##Hand:

A hand is an ArrayList of Cards which represents the cards the player and dealer have. When the hand is constructed, it takes two cards and adds them to the variable and ArrayList attributes. The hand keeps a count of the handValue which is the integer total of the value of the cards in the hand. The cards Rank is added to Ranks and the Values of the cards are added to Values.

##Player:

The player Class handles **WIP**

###Update 3/12/14:

Project due 3/15/14 and will only include a console version. After the project is turned in the program will continue to be developed with a GUI and bug fixes as priorities. Ideally interfaces and other changes can be implemented once the core game mechanics are finished.


