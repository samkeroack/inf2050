Liste des exigences
===================

TP1.1 : Les champs du fichier d'entrée doivent toujours être présents : nom,
genre, age, fumeur.tabac, fumeur.cannabis, alcool.

TP1.2 : Le genre doit être une valeur numérique de ISO 5218 (0, 1, 2, 9).

TP1.3 : Personne de moins de 18 ans, elle n'est pas éligible à l'assurance.

TP1.4 : Femme âgée de plus de 85 ans (donc 86 et plus), elle n'est pas éligible à l'assurance.

TP1.5 : Si un homme a plus de 80 ans (donc 81 et plus), il n'est pas éligible à l'assurance.

TP1.6 : Si une personne fume du tabac et du cannabis (les deux), elle n'est pas éligible à l'assurance.

TP1.7 : Les noms des fichiers d'entrée et de sortie sont reçus en paramètre au programme.

TP1.8 : Terminer l'exécution avec message d'erreur à la console si entrée non conforme.

TP2.1 : Le champ antecedent doit être présent et doit contenir une liste d'objet

TP2.2 : Le champ sports doit être présent et contenir une liste de chaînes de caractères

TP2.3 : Le champ date de naissance est un string en format ISO8601

TP2.4 : Une personne sans genre (0 ou 9) est éligible à l'assurance de 18-85 ans.

TP2.5 : Une personne pratiquant ces sports n'est pas eligible : Bungee, Saut en parachute, escalade.

TP2.6 : Le montant de base de l'assurance est calculée à partir du sexe et de l'âge de la personne selon ce tableau :

| Tranche d'âge (les bornes sont inclusives) | Homme | Femme et sans genre
| ------------------------------------------ | ----- | -------------------
| De 18 à 29 ans | 150 $ | 100 $ 
| De 30 à 40 ans | 165 $ | 140 $ 
| De 41 à 59 ans | 200 $ | 155 $ 
| De 60 à 73 ans | 350 $ | 250 $ 
| De 74 à 85 ans | 700 $ | 600 $ 


TP2.7 : Le montant annuel de l'assurance est 100$ de plus si la personne est fumeuse d'une substance.

TP2.8 : Le montant annuel de l'assurance est bonifié de 5% du montant de base si la personne consomme de l'alcool.

TP2.9 : Le montant annuel de l'assurance est bonifié de 15% du montant de base si la personne a plus de deux antecedents médicaux. 

TP2.10 : Le montant annuel de l'assurance est bonifié de 25$ si la personne ne pratique aucun sport.

TP2.11 : Le montant annuel de l'assurance est bonifié de 50% du montant de base si la personne a eu un diagnostic de cancer.

TP3.1 : Le champ "assurance_collective" doit être présent et doit contenir un boolean.

TP3.2 : Si "assurance_collective" est true, les champs suivants doivent se trouver à la suite du fichier d'entrée : 
+ Le nom de l'employeur (String)
+ Le numéro du contrat (String)
+ La date d'embauche (String)
+ Le pourcentage de l'assurance payé par l'employeur (Int)
+ La ville du lieu de travail (String)

TP3.3 : La personne n'est pas eligible si elle travaille dans l'une des villes suivantes : "Havres-Saint-Pierre", "Chibougamau",
        "Carignan", "Entrelacs" ou "Fasset".

TP3.4 : La personne n'est pas éligible si elle travaille pour cet employeur depuis moins de 3 mois.

TP3.5 : La date d'embauche doit être en format ISO 8601.

TP3.6 : Le nom de l'employeur doit contenir au minimum 5 caractères et au maximum 50 caractères.

TP3.7 : Le pourcentage de l'employeur doit être un entier entre 0 et 100 inclusivement.

TP3.8 : Le numéro de contrat doit débuter par une des lettres suivantes : A, R, H. Il doit être suivi de
        4 chiffres représentant un nombre entre 1000 et 7000 inclusivement.

TP3.9 : La part employeur est calculée en fonction du pourcetage payé par l'employeur appliqué sur le montant final de l'assurance. 
        La part employeur additionnée à la part employé doit donner le montant annuel. Si le calcul de la part employeur fait en sorte qu'un
        sous est divisé, c'est toujours l'employeur qui paie ce sous.




Plan de tests
=============

| No. | Fonctionnalités | Description             | Données                                     | Résultat attendu
| --- | --------------- | -----------             | -----------------                           | ----------------
| C1  | TP1.1           | Champ nom manquant      | Données complètes, sans le nom              | Message d'erreur
| C2  | TP1.1           | Champ genre manquant    | Données complètes, sans genre               | Message d'erreur
| C3  | TP1.1           | Champ age manquant      | Données complètes, sans age                 | Message d'erreur
| C4  | TP1.1           | Champ tabac manquant    | Données complètes, sans tabac               | Message d'erreur
| C5  | TP1.1           | Champ cannabis manquant | Données complètes, sans cannabis            | Message d'erreur
| C6  | TP1.1           | Champ alcool manquant   | Données complètes, sans alcool              | Message d'erreur
| C7  | TP1.2           | Genre non numérique     | Mettre le genre à "1"                       | Message d'erreur
| C8  | TP1.2           | Genre non valide        | Mettre le genre à 3                         | Message d'erreur
| C9  | TP1.3           | Personne mineure        | Age = 17                                    | Non éligible
| C10 | TP1.3           | Personne majeure        | Age = 18, ne fume pas                       | Éligible
| C11 | TP1.4           | Femme éligible          | Age=85, genre=2, ne fume pas                | Éligible
| C12 | TP1.4           | Femme âgée              | Age = 86, genre=2, ne fume pas              | Non éligible
| C13 | TP1.5           | Homme éligible          | Age=80, genre=1, ne fume pas                | Éligible
| C14 | TP1.5           | Homme trop âgé          | Age=81, genre=1, ne fume pas                | Non éligible
| C15 | TP1.6           | Grand fumeur            | Conforme, fume les deux subs.               | Non éligible
| C16 | TP1.6           | Fumeur réglo            | Conforme, fume du cannabis                  | Éligible
| C17 | TP1.6           | Fumeur réglo #2         | Conforme, fume du tabac                     | Éligible
| C18 | TP1.7           | Sans argument           |                                             | Message d'erreur
| C19 | TP1.7           | 1 seul argument         |                                             | Message d'erreur
| C20 | TP1.7           | 3 arguments             |                                             | Message d'erreur
| C21 | TP1.8           | Le fichier d'entrée n'existe pas |                                    | Message d'erreur
| C22 | TP1.8           | Le fichier d'entrée ne contient pas du JSON |                         | Message d'erreur
| C23 | TP1.8           | Le fichier d'entrée contient du JSON invalide | Retirer une virgule   | Message d'erreur
| C24 | TP1.8           | Pas le droit de lire le fichier d'entrée |                            | Message d'erreur
| C25 | TP1.8           | Pas de droit d'écrire le fichier de sortie |                          | Message d'erreur
| C26 | TP1.8           | L'entrée contient une valeur qui n'est pas du bon type | age="vingt"  | Message d'erreur
| C27 | TP2.1           | Champ antecedents manquant | Données complètes, sans les antecedents  | Message d'erreur
| C28 | TP2.1           | Champ diagnostic manquant | Données complètes, sans le diagnostic     | Message d'erreur
| C29 | TP2.1           | Champ depuis manquant   | Données complètes, sans le depuis           | Message d'erreur
| C30 | TP2.1           | Antecedents n'est pas un JSONARRAY | antecedent contient un JSONOBJET | Message d'erreur
| C31 | TP2.1           | L'array antecedents ne contient pas d'objects | pas d'{} antecedents  | Message d'erreur
| C32 | TP2.1           | Diagnostic contient pas des strings | Diagnostic avec des booleans    | Message d'erreur
| C33 | TP2.1           | L'array contient un objet vide | Antecedent avec objet vide           | Eligible
| C34 | TP2.2           | Champ Sports manquant   | Donnée complètes, sans le sports            | Message d'erreur
| C35 | TP2.2           | Sports contient pas des strings | Sports avec des ints                | Eligible        
| C36 | TP2.3           | Date de naissance invalide | Pas en format ISO8601                    | Message d'erreur
| C37 | TP2.3           | Date de naissance impossible | 13ième mois                            | Message d'erreur
| C38 | TP2.3           | Date de naissance future | Année de naissance = 2021                  | Message d'erreur
| C39 | TP2.3           | Date de naissance invalide | Jour = 32                                | Message d'erreur
| C40 | TP2.4           | Jeune personne non-genrée | 18 ans et genre = 0                       | Eligible 
| C41 | TP2.4           | Vieille personne non-genrée | 85 ans et genre = 0                     | Eligible
| C42 | TP2.4           | Trop vieille personne non-genrée | 86 ans et genre = 9                | Non-eligible
| C43 | TP2.4           | Trop jeune personne non-genrée | 17 ans et genre = 9                  | Non-eligible
| C44 | TP2.5           | Personne sports dangereux | Conforme, sports = Bungee, baseball       | Non-eligible
| C45 | TP2.5           | Personne sports dangereux | Conforme, sports = sAuT En PARAchuTE      | Non-eligible
| C46 | TP2.5           | Personne sports non-dangereux | Conforme, sports = Karaté             | Eligible
| C47 | TP2.6           | Jeune homme eligible | 18 ans, homme, non fumeur, pas d'alcool        | Eligible 150$ 
| C48 | TP2.6           | Homme eligible | 29 ans, homme, non fumeur, pas d'alcool, pas cancer  | Eligible 150$
| C49 | TP2.6           | Homme eligible | 30 ans, homme, non fumeur, pas d'alcool, pas cancer  | Eligible 165$
| C50 | TP2.6           | Homme eligible | 40 ans, homme, non fumeur, pas d'alcool, pas cancer  | Eligible 165$
| C51 | TP2.6           | Homme eligible | 41 ans, homme, non fumeur, pas d'alcool, pas cancer  | Eligible 200$
| C52 | TP2.6           | Homme eligible | 59 ans, homme, non fumeur, pas d'alcool, pas cancer  | Eligible 200$
| C53 | TP2.6           | Homme eligible | 60 ans, homme, non fumeur, pas d'alcool, pas cancer  | Eligible 350$
| C54 | TP2.6           | Homme eligible | 73 ans, homme, non fumeur, pas d'alcool, pas cancer  | Eligible 350$
| C55 | TP2.6           | Homme eligible | 74 ans, homme, non fumeur, pas d'alcool, pas cancer  | Eligible 700$
| C56 | TP2.6           | Homme eligible | 80 ans, homme, non fumeur, pas d'alcool, pas cancer  | Eligible 700$
| C57 | TP2.6           | Femme eligible | 18 ans, femme, non fumeur, pas d'alcool, pas cancer  | Eligible 100$
| C58 | TP2.6           | Femme eligible | 29 ans, femme, non fumeur, pas d'alcool, pas cancer  | Eligible 100$
| C59 | TP2.6           | Sans genre eligible | 30 ans, sans genre base                         | Eligible 140$
| C60 | TP2.6           | Femme eligible | 30 ans, femme, non fumeur, pas d'alcool, pas cancer  | Eligible 140$
| C61 | TP2.6           | Femme eligible | 41 ans, femme, non fumeur, pas d'alcool, pas cancer  | Eligible 155$
| C62 | TP2.6           | Sans genre eligible | 59 ans, femme, non fumeuse, pas d'alcool, pas cancer  | Eligible 155$
| C63 | TP2.6           | Femme eligible | 60 ans, femme, non fumeuse, pas d'alcool, pas cancer  | Eligible 250$
| C64 | TP2.6           | Femme eligible | 73 ans, femme, non fumeuse, pas d'alcool, pas cancer  | Eligible 250$
| C65 | TP2.6           | Genre inconnu eligible | 74 ans, femme, non fumeuse, pas d'alcool, pas cancer  | Eligible 600$
| C66 | TP2.6           | Femme eligible | 85 ans, femme, non fumeuse, pas d'alcool, pas cancer  | Eligible 600$
| C67 | TP2.7           | Femme eligible fumeuse | 42 ans, femme, base + fumeuse tabac          | Eligible 255$
| C68 | TP2.7           | Homme eligible fumeur | 80 ans, homme, base + fumeur cannabis         | Eligible 800$
| C69 | TP2.7           | Homme fumeur x2 | 42 ans, homme, base + fumeur 2 substances           | Non eligible
| C70 | TP2.8           | Femme eligible alcool | 85 ans, femme, base + alcool                  | Eligible 630$
| C71 | TP2.8           | Homme eligible alcool | 63 ans, homme, base + alcool                  | Eligible 367,5$
| C72 | TP2.8           | Femme eligible alcool + tabac | 85 ans, femme, fumeuse tabac, alcool  | Eligible 730$
| C73 | TP2.8           | Homme eligible alcool + tabac | 18 ans homme, fumeur cannabis, alcool | Eligible 257,5$
| C74 | TP2.9           | Femme eligible 2 antecedents | 85 ans, femme base + 2 antecedents     | Eligible 600$
| C75 | TP2.9           | Femme eligible 3 antecedents | 85 ans, femme base + 3 antecedents     | Eligible 690$
| C76 | TP2.9           | Homme eligible 5 antecedents | 18 ans, homme base + 5 antecedents     | Eligible 172,5$
| C77 | TP2.10          | Femme eligible 0 sport | 54 ans, femme base + 0 sport                 | Eligible 180$
| C78 | TP2.10          | Homme eligible 0 sport | 29 ans, homme base + 0 sport                 | Eligible 175$
| C79 | TP2.10          | Sans genre eligible 0 sport| 32 ans montant base + 0 sport            | Eligible 165$
| C80 | TP2.10          | Sans genre eligible 0 sport + tabac | 42 ans montant base + fumeuse + 0 sport | Eligible 280$
| C81 | TP2.11          | Sans genre eligible cancer | 42 ans montant base + cancer vessie      | Eligible 232,50$
| C82 | TP2.11          | Homme eligible fumeur cancer | 59 ans montant base + fumeur tabac + cancer prostate | Eligible 400$
| C83 | TP2.11          | Sans genre eligible 0 sport + cancer | 80 ans montant base + caNcer sein + 0 sport | Eligible 925$
| C84 | TP2.11          | Femme eligible 0 sport + fumeuse + cancer | 32 ans montant base + fumeuse tabac + cancer poumon + 0 sport | Eligible 335$
| C85 | TP3.1           | Champ assurance collective manquant | données complètes sans assurance collective | Message d'erreur
| C86 | TP3.1           | Assurance collective = mauvais type | assurance collective avec un int | Message d'erreur
| C87 | TP3.1           | assurance collective = false  | 54 ans, femme base + 0 sport           | Eligible 180$
| C88 | TP3.2           | assCol = true et nom employeur manquant | Donnée complète sans "nom_employeur" | Message d'erreur
| C89 | TP3.2           | assCol = true et numéro contrat manquant | Donnée complète sans "numero_contrat" | Message d'erreur
| C90 | TP3.2           | assCol = true et date d'embauche manquant | Donnée complète sans "date d'embauche" | Message d'erreur
| C91 | TP3.2           | assCol = true et part employeur manquant | Donnée complète sans "part employeur" | Message d'erreur
| C92 | TP3.2           | assCol = true et lieu travail manquant | Donnée complète sans "lieu travail" | Message d'erreur
| C93 | TP3.3           | Lieu de travail non accepté | Lieu de travail = "Havre-saint-pierre" | Non-eligible
| C94 | TP3.3           | Lieu de travail non accepté | Lieu de travail = "Chibougaman" | Non-eligible
| C95 | TP3.3           | Lieu de travail non accepté | Lieu de travail = "Carignan" | Non-eligible
| C96 | TP3.3           | Lieu de travail non accepté | Lieu de travail = "Entrelacs" | Non-eligible
| C97 | TP3.3           | Lieu de travail non accepté | Lieu de travail = "Fasset" | Non-eligible
| C98 | TP3.4           | Expérience < 3 mois | Donnée complète, travail depuis 2 mois à cet emploi | Non-eligible
| C99 | TP3.4          | Expérience > 3 mois | Donnée complète, travail depuis 2 ans à cet emploi | Eligible
| C100 | TP3.5          | Date d'embauche invalide | Date d'embauche = "09/09/1999" | Message d'erreur
| C101 | TP3.5          | Date d'embauche invalide | Date d'embauche = "12 mars 2002" | Message d'erreur
| C102 | TP3.6          | Nom employeur invalide | Nom employeur = "ONU" | Message d'erreur
| C103 | TP3.6          | Nom employeur valide | Nom employeur = "McGil" | Eligible
| C104 | TP3.6          | Nom Employeur invalide | Nom employeur = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz12345" | Message d'erreur
| C105 | TP3.7          | Pourcentage employeur trop élevé | Part employeur = 101 | Message d'erreur
| C106 | TP3.7          | Pourcentage employeur négatif | Part employeur = -5 | Message d'erreur
| C107 | TP3.8          | Numéro de contrat invalide (lettre) | Numero de contrat = "W2000" | Message d'erreur
| C108 | TP3.8          | Numero de contrat invalide (2 lettres) | Numero de contrat = "RH1000" | Message d'erreur
| C109 | TP3.8          | Numero de contrat invalide (Nombre) | Numero de contrat = "R9000" | Message d'erreur
| C110 | TP3.8          | Numero de contrat valide minuscule | Numero de contrat = "r4000" | Eligible
| C111 | TP3.9          | Part totales à payer | Part employeur = 51 | Eligible, Montant annuel = 367,5, Part employé = 187,43, Part employeur = 180,07  







