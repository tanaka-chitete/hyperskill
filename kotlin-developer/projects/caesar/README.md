# Caesar

Caesar is a command line program written in Kotlin which hides encrypted messages in images.

## Getting Started

### Installation
1. Download [`caesar-master.zip`](https://github.com/tanaka-chitete/caesar/archive/master.zip), the archive of the `caesar-master` directory
2. Open a new terminal window where the archive was downloaded
3. Unzip the archive using the following command to obtain `caesar-master`:
```
unzip caesar-master.zip
```
4. Delete `caesar-master.zip` using the following command:
```
rm caesar-master.zip
```
5. Using the previously-opened terminal window, navigate to `caesar-master` using the following command:
```
cd caesar-master
``` 

### Execution
To begin execution, execute the following command:
```
gradle run
```

Sample usage is outlined as follows:
```
> gradle run
Task (hide, show, exit):
> hide
Input image file:
> dream_car.png
Output image file:
> dream_car_hidden.png
Message to hide:
> My dream car is the 2018 Porsche 911 GT2 RS.
Password:
> dreamy
Message saved in dream_car_hidden.png image.
Task (hide, show, exit):
> exit
Bye!
> gradle run
Task (hide, show, exit):
> show
Input image file:
> dream_car_hidden.png
Password:
> dreamy
Message:
My dream car is the 2018 Porsche 911 GT2 RS.
Task (hide, show, exit):
> exit
Bye!
```

Note that `>` indicates user input.

### Restoration
To restore the `caesar-master` directory to its original state, enter the following:
```
gradle clean
```

## Author
Tanaka Chitete
* [Linkedin](https://www.linkedin.com/in/tanaka-chitete/)

## Acknowledgments
* Thank you to [DomPizzie](https://github.com/DomPizzie) for the [template](https://gist.github.com/DomPizzie/7a5ff55ffa9081f2de27c315f5018afc)
