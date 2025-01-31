# SRP

- La classe Jeu viole le SRP car elle gère :
  - La création du personnage
  - La génération du donjon
  - L'affichage de la carte
  - La gestion des combats
  - La gestion des déplacements
 
 # OCP 
Le système de combat n'est pas extensible :
- Les types de monstres sont codés en dur
- Les actions de combat sont limitées et non extensibles
- Pas d'abstraction pour les différents types d'événements


# ISP
Pas de présence d'interface ?

# DIP
- Jeu dépend directement des implémentations concrètes
- Pas d'injection de dépendances

# Remarques 
- Méthodes trop longues dans Jeu (notamment explorerDonjon et lancerCombat)
- Duplication de code dans la gestion des statistiques
- Nombres magiques non constants
- Manque de validation des entrées utilisateur
