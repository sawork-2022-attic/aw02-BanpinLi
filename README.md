# POS in Shell

The demo shows a simple POS system with command line interface. 

To run

```shell
mvn clean spring-boot:run
```

Currently, it implements three commands which you can see using the `help` command.

```shell
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.5.7)
 
shell:>help
AVAILABLE COMMANDS

Built-In Commands
        clear: Clear the shell screen.
        exit, quit: Exit the shell.
        help: Display help about available commands.
        history: Display or save the history of previously run commands
        script: Read and execute commands from a file.
        stacktrace: Display the full stacktrace of the last error.

Pos Command
        a: Add a Product to Cart
        n: New Cart
        p: List Products
```

Everytime a customer come to make a purchase, use `n` to create a new cart and then use `a ${productid} ${amount}` to add a product to the cart.

Please make the POS system robust and fully functional by implementing more commands, for instance, print/empty/modify cart.

Implementing a PosDB with real database is very much welcome. 

Please use asciinema (https://asciinema.org) to record a demo and submit the url in QQ group. 

And please elaborate your understanding in layered systems via this homework in your README.md.

---
### 我对于分层的理解
#### 1、各层独立性提高
当我们使用分层开发的时候，各层之间是相互独立的，并不会产生很强烈的相关性，上层应用不用关心下层服务是怎么实现的而是按照规定使用接口就可以，也不用关心更上层应用是如何进行使用的，只需要做到按照规定来对接口进行相应实现就可以了。
#### 2、灵活性提高
前面说到，每一层不需要关系其他层是怎么实现的，只需要关注提供的接口完成什么样的功能即可，这就意味着对于一个接口我们可以有多种实现方式，这些实现方式可能适用于不同的场景，使得灵活性大大的提高了。
#### 3、简化开发
合理的分层，可以将一个复杂任务分解成多个子任务，开发人员就只用针对于这些子任务进行解决，而不用过多的去关心整体的解决方案，可以很大程度上简化开发和提高开发效率。
