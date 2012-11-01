public class practiceTest
{
public static void main(String[]args)
{
Card card = new Card();
Card otherCard = card;
boolean b;
if(b = card == otherCard)
System.out.println(b);
}
}
class Card
{
private int rank;
private String suit;
public Card()
{
suit = "Clubs";
rank = 2;
}
public String toString()
{
return (rank + " of " + suit);
}
} 