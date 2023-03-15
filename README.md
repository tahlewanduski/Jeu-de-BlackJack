# Jeu-de-BlackJack

Pour éxécuter lancez la commande ant

####################################################

Nos règles
Dans ce BlackJack nous avons décidé que chaque joueur joue pour lui-même, ainsi il n’y a pas de système de mise. Seulement un compteur de victoires et de défaites selon le résultat de la partie.


Classes du projet:

  1 - Cartes 
    a - Cartes	
    b - Paquet
    c - Paquet Factory
  2 - Blackjack 
    a - PlayerIA
    b - IA
    c - Game
    
Patterns utilisés
  Nous avons utilisé les patterns suivant:
    - MVC et Observer pour la vue
    - Adapter pour adapter JPanel au cartes de notre jeu
    - Proxy pour arrêter de piocher quand la valeur de la main est trop grande
