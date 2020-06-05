// red "\u001B[31m"
// green "\u001B[32m"
// yellow "\u001B[33m"
// reset "\u001B[0m"
import kotlinx.coroutines.*

open class randomx // parent/base class (Inheritance) #1
{
    val randfunc={a:Int,b:Int->(a..b).random()} // lamda expression #2
    var money=500
}

class mainx : randomx() // child/derived class (Inheritance)
{
    fun start(): Int
    {
        while(true)
        {
            println("\n  //********************//\n // "+"\u001B[36m"+"You have $money\$ left"+"\u001B[0m"+" //\n//********************//\n") // string template #3
            print("\u001B[33m" + "Press 'Y' to play 'N' to exit : " +"\u001B[0m")

            var startgame = readLine()
            if (startgame != null) {
                startgame=startgame.toUpperCase()
            }

            if(startgame=="Y")
            {
                loop()
            }
            else if (startgame=="N")
            {
                println("\u001B[31m"+"You have decided to exit this game...See you again Next Time !"+"\u001B[0m")
                return 1
            }
            else
            {
                println("\n"+"\u001B[31m"+"Please enter 'Y' or 'N' only..."+"\u001B[0m")
            }
        }
    }
    fun loop(): Int
    {
        if(money<100)
        {
            println("\n  //******************************//\n // OOPS!...You ran out of money //\n//******************************//\n")
            return 1
        }
        else
        {
            print("\u001B[33m"+"Press 'H' for Heads and 'T' for Tails : "+"\u001B[0m")
            var gamevalue = readLine()
            if (gamevalue != null)
            {
                gamevalue=gamevalue.toUpperCase()
            }
            if (gamevalue!="H" && gamevalue!="T")
            {
                println("\n"+"\u001B[31m"+"Please enter 'H' or 'T' only..."+"\u001B[0m")
                loop()
            }
            else
            {
                val randm = randfunc(1,2)
                val randvalue : String
                if (randm == 1) { randvalue = "H"}
                else if (randm == 2) { randvalue = "T"}
                else { randvalue = ""; println("Error occurred")}

                if(gamevalue==randvalue)
                {
                    money=money+100
                    println("\n  //*******************//\n // "+"\u001B[32m"+"Congrats You Won!"+"\u001B[0m"+" //\n//*******************//")
                    return 1
                }
                else
                {
                    money=money-100;
                    println("\n  //******************************//\n // "+"\u001B[31m"+"OOPS...Better Luck Next Time"+"\u001B[0m"+" //\n//******************************//")
                    return 1
                }

            }

        }
        return 1
    }
}

suspend fun main()
{

    var name:String?  // null safety...#4
    name = null

    val job1 = GlobalScope.launch{    // Coroutine...#5
        delay(5500L)

        print("Enter your name : ")
        print("\u001B[0m")
        name = readLine().toString()

        if (name == "")
        {
            name =null
        }

        print("\u001B[31m")
        println("\nWelcome $name...") // String Templates #3
        print("\u001B[0m")
        val obj=mainx()
        obj.start()
    }

    val job2 = GlobalScope.launch {
        // Coroutine...#5
        delay(0L)
        print("\u001B[33m")
        print("S")
        delay(500L)
        print("t")
        delay(500L)
        print("a")
        delay(500L)
        print("r")
        delay(500L)
        print("t")
        delay(500L)
        print("i")
        delay(500L)
        print("n")
        delay(500L)
        print("g")
        delay(500L)
        print(".")
        delay(500L)
        print(".")
        delay(500L)
        print(".\n")
    }

    job2.join()
    job1.join()
}