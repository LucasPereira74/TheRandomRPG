# ProjectRandomRPG
School Android Project

Fonctionnement :

Cette application a pour objectif de laisser l'utilisateur créer un personnage caricaturale d'un RPG. Pour cela, lors de la première page/fragment (FirstFragment) vous aurez devant vous trois boutons :

-> Le premier "CREATE" permet de se rediriger vers une seconde page/fragment (SecondFragment) dans lequel débute la création de personnage.

-> Le second "LOAD" permet de diriger vers une troisième page/fragment (ThirdFragment) où on pourra modifier les équipements du personnage créer précédement.

-> Le troisième "QUITT" qui ne sert à rien

![Alt text](http://full/path/to/img.jpg "First Fragment")

Commencer par appuyer sur "Create" pour débuter la création d'un personnage Une fois dans la seconde page/fragment (SecondFragment), la création de personnage commence :

-> Vous avez alors à faire un choix entre 3 races (Human/Orc/Elv) et 3 classes (Warrior/Magician/Assassin).

-> Les visuels des personnages ont été créé avec PowerPoint
-> Une fois votre choix terminé parmis les 9 combinaisons possibles, vous pouvez appuyer sur le bouton "CREATE" en bas de la page. Cela vous redirigera vers la première page.

Maintenant que vous êtes revenue à la page princicale (FirstFragment), vous pouvez appuyer sur le bouton load qui vous permettra de choisir un équipement pour le personnage que vous venez de créer (si vous n'avez pas créé de personnage, la page s'instenciera avec un Human Warrior).

Dans la troisième page/fragment (ThirdFragment) vous pourrez ajouter à votre personnage des équipements. Vous y verrez aussi un visuel de ce dernier avec les caractéristiques de celui-ci en fonction de vos choix précédents:

-> Le choix de l'armure se fait par un menu déroulant (RecyclerView) dans lequel vous trouverez un total de 15 armures différentes qui sont séparées en 3 styles (Iron/Leather/Magic) et allant du level 1 au level 5. Le choix d'une armure (en cliquant dessus) ajoutera les caractéristiques de l'amure à celle de votre personnage. (Les armures peuvent être cumulées mais pas retirées donc les statistiques se cumule aussi)

-> Le choix de l'arme se fait en appuyant sur un des trois boutons (Sword/Stick/Dagger). Une fois le choix de votre arme faite vous pouvez la retirer en appuyant une nouvelle foix dessus. Vous ne pouvez pas cumuler les armes (un message d'erreur apparaitra si vous le faite).

Et voilà, vous avez créé votre personnage de "TheRandomRPG".

Pereira Lucas, Classe 31
