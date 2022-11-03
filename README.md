## Application Android Tv Shows
# API
*Swagger*:  
[Documentation de l'API](https://tvshowdbapi.herokuapp.com/)
## Fonctionnalité
**Détails sur les requêtes à l'API utilisées:**

    GET: 
        -Recevoir les détails de l'émission selectionnée
        -Recevoir les détails sur les acteurs de l'émission selectionnée
        -Recevoir les saisons l'émission selectionnée
        -Recevoir l'information sur la liste des émission préféré de l'utilisateur
         (pour l'afficher et pour vérifier)
        -Recevoir les émissions dans la BD

    POST:
        -Envoyer une demande de token pour pouvoir utiliser les autres requêtes et se connecter
        -Envoyer (Update) la liste des favoris de l'utilisateur

    
## Notions utilisées
- Les fragments
- ViewModels (MVVM)
- ViewModelFactory
- La navigation et la barre de navigation
- Volley (Requête à un API)
- Désérialisation Gson
- Utilisation de models pour Désérialisation
## Authors

- [David Dechaine](https://github.com/DavidDechaine)
