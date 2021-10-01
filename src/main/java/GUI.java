import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static java.lang.System.exit;

public class GUI {

    public void displayMenu(){
            System.out.println("****************************MENU******************************");
            System.out.println("[1] Calculate profit");
            System.out.println("[0] Exit program");
            System.out.println("**************************************************************");
            System.out.print("Select option: ");
        }

        public void navigateMenu(){
            try {
                Scanner scanner = new Scanner(System.in);
                int choiceInMenu = scanner.nextInt();
                switch (choiceInMenu) {
                    case 1:
                        CryptocurrencyData cryptocurrencyData = GetApiData.getApiData();
                        ProfitCalculator profitCalculator = new ProfitCalculator();
                        System.out.println("CURRENCY: 1: EUR 2: GBP 3: USD");
                        int currencyChoice = scanner.nextInt();
                        switch(currencyChoice){
                            case 1:
                                profitCalculator.setCurrency(FiatCurrency.EUR);
                                profitCalculator.setCurrent_rate(cryptocurrencyData.getEurBpi().getRate_float());
                                break;
                            case 2:
                                profitCalculator.setCurrency(FiatCurrency.GBP);
                                profitCalculator.setCurrent_rate(cryptocurrencyData.getGbpBpi().getRate_float());
                                break;
                            case 3:
                                profitCalculator.setCurrency(FiatCurrency.USD);
                                profitCalculator.setCurrent_rate(cryptocurrencyData.getUsdBpi().getRate_float());
                                break;
                        }
                        System.out.println("Insert amount you have purchased: ");
                        int amount = scanner.nextInt();
                        profitCalculator.setAmount(amount);
                        System.out.println("Insert exchange rate at the date of purchase: ");
                        int purchaseRate = scanner.nextInt();
                        profitCalculator.setPurchase_rate(purchaseRate);
                        profitCalculator.calculateProfit();

                        if(profitCalculator.getProfit()<0){
                            System.out.println("You have lost " + profitCalculator.getProfit() + " " + profitCalculator.getCurrency());
                        }
                        else if(profitCalculator.getProfit()==0){
                            System.out.println("Your profit is equal to zero");
                        } else if (profitCalculator.getProfit()>0){
                            System.out.println("You have earned " + profitCalculator.getProfit() + " " + profitCalculator.getCurrency());
                        }
                        break;
                    case 0:
                        exit(0);
                        break;
                }
            } catch (InputMismatchException e){
                System.out.println("Input mismatch! Try again...");
                //e.printStackTrace();
            } catch (NoSuchElementException e) {
                System.out.println("Wrong number! Try again...");
                //e.printStackTrace();
            } catch (IllegalStateException e){
                System.out.println("Oops, sth went wrong! Try again...");
                //e.printStackTrace();
            } catch (Exception e){
                //e.printStackTrace();
                System.out.println("Unknown error! Try again...");
            }
        }

        public void printWelcomeMessage(){
            System.out.println("                    *******************************************");
            System.out.println("                    Welcome in cryptocurrency profit calculator");
            System.out.println("                    *******************************************");
        }
    }

