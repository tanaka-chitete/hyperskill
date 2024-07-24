# Epsilon

Epsilon is a command line multi-lingual online translator designed and implemented in Python using translations retrieved and parsed from ReversoContext using BeautifulSoup.

## Getting Started

### Installation
1. Download [`epsilon-master.zip`](https://github.com/tanaka-chitete/epsilon/archive/master.zip), the archive of the `epsilon-master` directory
2. Open a new terminal window where the archive was downloaded
3. Unzip the archive using the following command to obtain `epsilon-master`:
```
unzip epsilon-master.zip
```
4. Delete `epsilon-master.zip` using the following command:
```
rm epsilon-master.zip
```
5. Using the previously-opened terminal window, navigate to `epsilon-master` using the following command:
```
cd epsilon-master
``` 

### Execution
To begin execution, execute the following command:
```
python3 epsilon.py
```

Sample usage is outlined as follows:
```
> python3 epsilon.py

Epsilon (v2.3)

1. Translate
0. Close

Operation: 1

Source Language

1.  Arabic
2.  Dutch
3.  English
4.  French
5.  German
6.  Hebrew
7.  Japanese
8.  Polish
9.  Portuguese
10. Romanian
11. Russian
12. Spanish
13. Turkish

Language: 3

Target Language

0.  All languages
1.  Arabic
2.  Dutch
3.  English
4.  French
5.  German
6.  Hebrew
7.  Japanese
8.  Polish
9.  Portuguese
10. Romanian
11. Russian
12. Spanish
13. Turkish

Language: 4

Text to translate: Hello, World!

Translating...

French Translation:
bonjour tout le monde

French Example:
There was a time when not even a simple "Hello, World!" in C couldn't do this.
Il était un temps où même un simple "Hello, World!" en C ne pouvait pas faire cela.

Translation file saved as Hello, World!.txt

Epsilon (v2.3)

1. Translate
0. Close

Operation: 0

Epsilon (v2.3)

>
```

### Restoration
Upon execution, if there are any translation files you wish to delete, execute the following command:
```
rm *.txt
```

## Author
Tanaka Chitete
* [Linkedin](https://www.linkedin.com/in/tanaka-chitete/)

## Acknowledgments
* Thank you to [DomPizzie](https://github.com/DomPizzie) for the [template](https://gist.github.com/DomPizzie/7a5ff55ffa9081f2de27c315f5018afc)
