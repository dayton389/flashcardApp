package com.flashcards;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Map<String, String> flashcards = new HashMap<>();
        
        System.out.println("What set would you like to study? Type 'numbers', 'nouns', or 'verbs' and 'start' to begin.");
        Scanner scanner = new Scanner(System.in);
        String startUp;

        while (true) {
            System.out.print("Enter set name or 'start': ");
            startUp = scanner.nextLine().trim().toLowerCase();

            if (startUp.equals("start")) {
                break; // Exit the loop and start the quiz
            } else if (startUp.equals("numbers")) {
                makeNumberCards(flashcards);
                System.out.println("Added number flashcards.");
            } else if (startUp.equals("verbs")) {
                makeVerbCards(flashcards);
                System.out.println("Added verb flashcards.");
            } else if (startUp.equals("nouns")) {
                makeNounCards(flashcards);
                System.out.println("Added noun flashcards.");
            } else {
                System.out.println("Invalid option. Try 'numbers', 'verbs', 'nouns', or 'start'.");
            }
        }


        List<String> keys = new ArrayList<>(flashcards.keySet());
        Collections.shuffle(keys);

        Set<String> correctAnswers = new HashSet<>();

        System.out.println("Italian Flashcards Quiz");
        System.out.println("Type the Italian word for each english word or number. Let's go!");

        long startTime = System.currentTimeMillis();
        int count = 0;

        while (correctAnswers.size() < keys.size()) {
            
            
            for (String front : keys) {
                if (correctAnswers.contains(front)) continue;
                
                clearConsole();
                long now = System.currentTimeMillis();    // End timing
                long elapsedMillis = now - startTime;
                System.out.print("("+ count + "/" + flashcards.size() + ")" + "Time: " + (elapsedMillis / 1000) / 60 + ':' + String.format("%02d", (elapsedMillis / 1000) % 60) + " What is " + front + " in Italian? ");
                String userAnswer = scanner.nextLine().trim().toLowerCase();
                String correct = flashcards.get(front).toLowerCase();

                if (userAnswer.equals(correct)) {
                    count += 1;
                    System.out.println("Correct!\n");
                    correctAnswers.add(front);
                } else {
                    System.out.println("Incorrect. The correct answer is: " + correct + "\n");
                }
                try {
                    Thread.sleep(1500); // 1 second delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        System.out.println("Great job! You completed all flashcards.");
        scanner.close();
    }

    public static void clearConsole() {
        for (int i = 0; i < 50; ++i) System.out.println();
    }
    public static void makeNumberCards(Map<String, String> flashcards) {
        String[] numbers = new String[101];
        String[] italianNumbers = new String[101];

        for (int i = 0; i <= 100; i++) {
            numbers[i] = String.valueOf(i);
        }

        // Italian equivalents
        String[] italianUnits = {
            "zero", "uno", "due", "tre", "quattro", "cinque", "sei", "sette", "otto", "nove"
        };
        String[] italianTeens = {
            "dieci", "undici", "dodici", "tredici", "quattordici", "quindici", "sedici", "diciassette", "diciotto", "diciannove"
        };
        String[] italianTens = {
            "", "", "venti", "trenta", "quaranta", "cinquanta", "sessanta", "settanta", "ottanta", "novanta"
        };

        // Fill italianNumbers array
        for (int i = 0; i <= 100; i++) {
            if (i < 10) {
                italianNumbers[i] = italianUnits[i];
            } else if (i < 20) {
                italianNumbers[i] = italianTeens[i - 10];
            } else if (i == 100) {
                italianNumbers[i] = "cento";
            } else {
                int tens = i / 10;
                int units = i % 10;
                String base = italianTens[tens];

                // Elide vowels before "uno" and "otto"
                if (units == 1 || units == 8) {
                    base = base.substring(0, base.length() - 1);  // remove trailing vowel
                }

                italianNumbers[i] = units == 0 ? base : base + italianUnits[units];
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            flashcards.put(numbers[i], italianNumbers[i]);
        }

    }

    public static void makeNounCards(Map<String, String> flashcards) {
        String[] italianNouns = {
            "uomo", "donna", "bambino", "famiglia", "amico", "scuola", "casa", "giorno", "notte", "tempo",
            "lavoro", "mano", "occhio", "città", "paese", "strada", "macchina", "soldi", "cibo", "acqua",
            "mese", "anno", "settimana", "ora", "minuto", "secondo", "cuore", "testa", "faccia", "corpo",
            "vita", "morte", "amore", "odio", "gioco", "libro", "storia", "lingua", "parola", "frase",
            "voce", "pensiero", "idea", "porta", "finestra", "sedia", "letto", "camera", "muro", "pavimento",
            "telefono", "computer", "luci", "sole", "luna", "stella", "mare", "montagna", "albero", "fiore",
            "animale", "cane", "gatto", "uccello", "pesce", "soldato", "polizia", "dottore", "insegnante", "studente",
            "banca", "negozio", "mercato", "chiesa", "ospedale", "bar", "ristorante", "treno", "aereo", "macchina fotografica",
            "giornale", "lettera", "penna", "matita", "quaderno", "borsa", "chiave", "orologio", "vestito", "scarpa",
            "musica", "film", "foto", "giardino", "parco", "colore", "numero", "nome", "domanda", "risposta"
        };

        String[] englishMeanings = {
            "man", "woman", "child", "family", "friend", "school", "house", "day", "night", "time",
            "work", "hand", "eye", "city", "country", "street", "car", "money", "food", "water",
            "month", "year", "week", "hour", "minute", "second", "heart", "head", "face", "body",
            "life", "death", "love", "hate", "game", "book", "story", "language", "word", "sentence",
            "voice", "thought", "idea", "door", "window", "chair", "bed", "room", "wall", "floor",
            "phone", "computer", "lights", "sun", "moon", "star", "sea", "mountain", "tree", "flower",
            "animal", "dog", "cat", "bird", "fish", "soldier", "police", "doctor", "teacher", "student",
            "bank", "store", "market", "church", "hospital", "bar", "restaurant", "train", "plane", "camera",
            "newspaper", "letter", "pen", "pencil", "notebook", "bag", "key", "watch/clock", "dress", "shoe",
            "music", "movie", "photo", "garden", "park", "color", "number", "name", "question", "answer"
        };

        for (int i = 0; i < italianNouns.length; i++) {
            flashcards.put(italianNouns[i], englishMeanings[i]);
        }
    }

    public static void makeVerbCards(Map<String, String> flashcards) {
        String[] italianVerbs = {
            "essere", "avere", "fare", "dire", "potere", "andare", "vedere", "dare", "sapere", "volere",
            "dovere", "stare", "parlare", "trovare", "lasciare", "prendere", "mettere", "pensare", "vivere", "sentire",
            "guardare", "chiedere", "tenere", "lavorare", "credere", "uscire", "arrivare", "cominciare", "mangiare", "scrivere",
            "leggere", "portare", "giocare", "correre", "dormire", "capire", "studiare", "aprire", "chiudere", "seguire",
            "perdere", "diventare", "finire", "comprare", "camminare", "spiegare", "incontrare", "usare", "cercare", "entrare"
        };

        String[] englishMeanings = {
            "to be", "to have", "to do/make", "to say", "can/to be able to", "to go", "to see", "to give", "to know (a fact)", "to want",
            "to have to/must", "to stay", "to speak", "to find", "to leave", "to take", "to put", "to think", "to live", "to hear/feel",
            "to watch", "to ask", "to hold/keep", "to work", "to believe", "to go out", "to arrive", "to begin", "to eat", "to write",
            "to read", "to bring/wear", "to play", "to run", "to sleep", "to understand", "to study", "to open", "to close", "to follow",
            "to lose", "to become", "to finish", "to buy", "to walk", "to explain", "to meet", "to use", "to search/try", "to enter"
        };

        for (int i = 0; i < italianVerbs.length; i++) {
            flashcards.put(italianVerbs[i], englishMeanings[i]);
        }
    }

}