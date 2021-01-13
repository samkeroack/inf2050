## Guide de l'utilisateur

Avant l'exécution du programme, il faut s'assurer d'avoir toutes les dépendances du fichier pom.xml sont installées.

Le .jar du logiciel peut être construit à l'aide de Maven.

Le logiciel utilise deux paramètres lors de son exécution à la ligne de commande, soit un fichier d'entrée des données et de sortie des données.

Les fichiers d'entrées et de sorties doivent être des documents JSON pour le bon fonctionnement de celui-ci.

+ Paramètre[0]=Fichier d'entrée (Profile Candidat)
+ Paramètre[1]=Fichier de sortie (Peut être vide, mais doit exister)*

*À noter que le fichier de sortie sera écrasé à chaques nouvelles exécutions.

Le fichier JSON d'entrée doit contenir la structure de donnée suivante : 

```
{
"nom": String,
"genre": int (ISO-5218)
"date_de_naissance": String (ISO-8601)
 "assurance_collective": Boolean
"fumeur": {
"tabac": Boolean
"cannabis": Boolean
},
 "alcool": Boolean
 "antecedents": [
 {
 "diagnostic": String,
 "depuis": String (ISO-8601)
 },
 {
 "diagnostic": String
 "depuis": String (ISO-8601)
 }
 ],
 "sports": [String, String],
 "employeur": String (Entre 5-50 char),
 "numero_contrat": String (Premier charactère A,R,H suivi d'un nombre entre 1000-7000),
 "date_embauche": String (ISO-8601),
 "part_employeur": int,
 "lieu_travail": String
}
```
