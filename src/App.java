import java.util.ArrayList;

import classes.Employe;

public class App {
    public static void main(String[] args) throws Exception {
        String id = "MA000";

        String[] lastnames = {"Albert", "Malik", "Vincent", "Youri", "Nael", "Bolan", "Dover", "Kliens", "Sika", "Jean", "Diane"};

        String[] firstnames = {"Nielson", "Yoan", "Gogh", "Dodo", "Miles", "Kiki", "Louik", "Lybe", "Niyle", "De Dieu", "Shur"};

        String[] positions = {"Directeur", "Chef de service", "Informaticien", "Chef de service", "Informaticien", "Comptable", "Chef de service", "Informaticien", "Informaticien", "Manager", "CTO"};

        Integer[] startYears = {2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010};

        Integer[] salaries = {120000, 55000, 40000, 45000, 45000, 45000, 45000, 35000, 35000, 60000, 70000};

        ArrayList<Employe> employes = new ArrayList<Employe>();

        
        // Question 1 - Créer et afficher la liste des employés
        for (int i = 0; i < lastnames.length; i++) {
            employes.add(new Employe(id + (i + 1), lastnames[i], firstnames[i], positions[i], startYears[i], salaries[i]));
        }

        System.out.println("Liste des employés :" + "\n");

        for (Employe employe : employes) {
            System.out.println(employe.display());
        }

        // Question 2 et 3 - Créer une méthode qui recherche un employé en connaissant son matricule
        System.out.println(searchEmployeById(employes, "MA0007"));
        System.out.println(searchEmployeById(employes, "MAAGG7"));

        // Question 4 - Afficher les employés dont l'année de prise de service est 2008
        System.out.println(SearchEmployeByStartYear(employes, 2008));

        // Question 5 - Afficher la masse salariale totale
        System.out.println(getTotalSalary(employes)); 

        // Question 6 - Afficher le ou les employés les plus anciens de l'entreprise
        System.out.println(searchOldestEmployes(employes));

        // Question 7 - Afficher le plus petit salaire de l'entreprise
        System.out.println(searchLowestSalary(employes));

        // Question 8 et 9 - Afficher le salaire le plus bas de l'entreprise et ajouter 550€
        System.out.println(searchEmployesWithLowestSalaryAndAdd(employes));

        // Question 10 - Afficher les employés informaticiens
        System.out.println(searchEmployesByJob(employes, "Informaticien"));

        // Question 11 et 12 - Calculer le total des salaires des chefs de service et le nombre d'employés
        System.out.println(CountEmployesAndgetTotalSalaryByJob(employes, "Chef de service"));

        // Question - 13 Afficher la liste de touts les employés au poste de chef de service
        System.out.println(displayEmployesByJob(employes, "Chef de service"));

        // Question 14 - Afficher les employés embauchés 5 ans avant 2020 et dont le salaire est compris entre 60000 et 150000€
        System.out.println(searchEmployesByYearAndSalary(employes, 5, 2020, 60000, 150000));

    }

    // Research method
    public static String searchEmployeById(ArrayList<Employe> employes, String id) {
        System.out.println("\n" + "Recherche d'un employé par son matricule : " + id + "\n");

        for (Employe employe : employes) {
            if (employe.getId().equals(id)) {
                return employe.display();
            }
        }
        return null;
    }

    // Find by year of hiring
    public static String SearchEmployeByStartYear(ArrayList<Employe> employes, Integer startYear) {
        System.out.println("\n" + "Recherche d'un employé par son année d'embauche : " + startYear + "\n");

        for (Employe employe : employes) {
            if (employe.getStartYear().equals(startYear)) {
                return employe.display();
            }
        }
        return null;
    }

    // Get total employes salary
    public static String getTotalSalary(ArrayList<Employe> employes) {
        System.out.println("\n" + "Calcul de la masse salariale totale :" + "\n");
        Integer totalSalary = 0;

        for (Employe employe : employes) {
            totalSalary += employe.getSalary();
        }

        return "Masse salariale totale : " + totalSalary + "€" + "\n";
    }

    // Search the oldest employee or employees
    public static String searchOldestEmployes(ArrayList<Employe> employes) {
        ArrayList<Employe> oldestEmployes = new ArrayList<>();
    
        int oldestYear = employes.get(0).getStartYear();
        for (Employe employe : employes) {
            if (employe.getStartYear() < oldestYear) {
                oldestYear = employe.getStartYear();
            }
        }
    
        for (Employe employe : employes) {
            if (employe.getStartYear() == oldestYear) {
                oldestEmployes.add(employe);
            }
        }

        StringBuilder result = new StringBuilder("\nListe des employés les plus anciens :\n\n");
        for (Employe employe : oldestEmployes) {
            result.append(employe.display()).append("\n");
        }

        return result.toString();
    }

    // Search the lowest salary
    public static String searchLowestSalary(ArrayList<Employe> employes) {
        Integer lowestSalary = employes.get(0).getSalary();
        for (Employe employe : employes) {
            if (employe.getSalary() < lowestSalary) {
                lowestSalary = employe.getSalary();
            }
        }
        return "\n" + "Le salaire le plus bas de l'entreprise est de : " + lowestSalary + "€" + "\n";
        
    }

    // Dsiplay employees with the lowest salary and add 550 at each salary
    public static String searchEmployesWithLowestSalaryAndAdd(ArrayList<Employe> employes) {
        ArrayList<Employe> employesWithLowestSalary = new ArrayList<>();
        Integer lowestSalary = employes.get(0).getSalary();
    
        for (Employe employe : employes) {
            if (employe.getSalary() <= lowestSalary) {
                lowestSalary = employe.getSalary();
            }
        }
    
        for (Employe employe : employes) {
            if(employe.getSalary() <= lowestSalary) {
                employesWithLowestSalary.add(employe);
            }
        }

        for (Employe employe : employesWithLowestSalary) {
            employe.setSalary(employe.getSalary() + 550);
        }
    
        StringBuilder result = new StringBuilder("\nListe des employés avec le salaire le plus bas et ajout de 550€ :\n\n");
    
        for (Employe employe : employesWithLowestSalary) {
            result.append(employe.display()).append("\n");
        }
    
        return result.toString();
    }

    // Find employes by job
    public static String searchEmployesByJob(ArrayList<Employe> employes, String job) {
        ArrayList<Employe> employesByJob = new ArrayList<>();
    
        for (Employe employe : employes) {
            if (employe.getJob().equals(job)) {
                employesByJob.add(employe);
            }
        }
    
        StringBuilder result = new StringBuilder("\nListe des employés par poste : " + job + "\n\n");
        for (Employe employe : employesByJob) {
            result.append(employe.display()).append("\n");
        }
    
        return result.toString();
    }

    // Calculate toalSalary per jobs and count number of employes
    public static String CountEmployesAndgetTotalSalaryByJob(ArrayList<Employe> employes, String job) {
        Integer totalSalary = 0;
        Integer countEmployes = 0;
    
        for (Employe employe : employes) {
            if (employe.getJob().equals(job)) {
                countEmployes++;
                totalSalary += employe.getSalary();
            }
        }
    
        return "Mass salariale des " + job + " : " + totalSalary + "€" + "\n" + "Nombre d'employés : " + countEmployes + "\n";
    }

    // Display list of employes by job
    public static String displayEmployesByJob(ArrayList<Employe> employes, String job) {
        ArrayList<Employe> employesByJob = new ArrayList<>();
    
        for (Employe employe : employes) {
            if (employe.getJob().equals(job)) {
                employesByJob.add(employe);
            }
        }
    
        StringBuilder result = new StringBuilder("\nListe des employés par poste : " + job + "\n\n");
        for (Employe employe : employesByJob) {
            result.append(employe.display()).append("\n");
        }
    
        return result.toString();
    }
    

    // Find employes by at least n year prior to a comparative year and between intervalled salaries
    public static String searchEmployesByYearAndSalary(ArrayList<Employe> employes, Integer seniority, Integer year, Integer minSalary, Integer maxSalary) {
        ArrayList<Employe> employesByYearAndSalary = new ArrayList<>();

        for (Employe employe : employes) {
            if (year - employe.getStartYear() >= seniority && employe.getSalary() >= minSalary && employe.getSalary() <= maxSalary) {
                employesByYearAndSalary.add(employe);
            }
        }

        StringBuilder result = new StringBuilder("\nListe des employés embauchés " + seniority + " ans avant " + year + " et dont le salaire est compris entre " + minSalary + " et " + maxSalary + "€" + "\n\n");

        for (Employe employe : employesByYearAndSalary) {
            result.append(employe.display()).append("\n");
        }

        return result.toString();
    }
}
