import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private List<String> requestCommands;
    private List<Integer> numbers;

    public FileManager() {
        requestCommands = new ArrayList<>();
        numbers = new ArrayList<>();
    }

    public List<String> getRequestCommands() {
        return requestCommands;
    }

    public void tokenizeFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                requestCommands.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public void tokenizeInsertionFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");

                for (String part : parts) {
                    try {
                        int number = Integer.parseInt(part);
                        numbers.add(number);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid number format: " + part);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }


    public void processCommands() {
        //System.out.println("Processing commands:");
        for (String command : requestCommands) {
            //System.out.println("Command: " + command);
            String input = command;

            if(hasSpaceBetweenCharacters(command) == true) {
                //System.out.println("\nHas space\n");
                // Remove espaços do início e do final da string
                String trimmedInput = input.trim();

                // Divide a string onde há espaços
                String[] parts = trimmedInput.split("\\s+");

                // Salva a primeira parte em requestCommand
                String requestCommand = parts[0];

                // Verifica se há uma segunda parte
                int methodParameter = 0;
                if (parts.length > 1) {
                // Tenta converter a segunda parte em int
                    try {
                        methodParameter = Integer.parseInt(parts[1]);
                    } catch (NumberFormatException e) {
                    System.err.println("Invalid method parameter: " + parts[1]);
                    }
                }
                // Ação para respectivo comando
                switch (requestCommand) {
                    case "ENESIMO":

                        break;
                    
                    case "POSICAO":

                        break;

                    case "IMPRIMA":
                        System.out.println("IMPRIMA method :" + " " + methodParameter);
                        break;

                    case "REMOVA":

                        break;

                    case "MEDIA":

                        break;
                }

            } else {
                //System.out.println("\nNo have space\n");
                String requestCommand = input.trim();

                switch (requestCommand) {
                    case "MEDIANA":
                        
                        break;
                    
                    case "CHEIA":

                        break;
                    
                    case "COMPLETA":

                        break;
                    default:
                        break;
                }
            }
        }
    }

    public static boolean hasSpaceBetweenCharacters(String input) {
        for (int i = 0; i < input.length() - 1; i++) {
            char currentChar = input.charAt(i);
            char nextChar = input.charAt(i + 1);

            if (currentChar != ' ' && nextChar == ' ') {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        fileManager.tokenizeFile("input/i.txt");

        fileManager.processCommands();
    }
}
