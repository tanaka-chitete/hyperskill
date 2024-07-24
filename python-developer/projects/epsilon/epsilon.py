from user_input import input_int
from operations import translate, close
from textwrap import dedent

def main():
    print()  # For formatting purposes
    while True:
        main_menu = """\
            Epsilon (v2.3)
            
            1. Translate
            0. Close
            """
        print(dedent(main_menu))
        user_input = input_int(0, 1, "Operation: ")
        print()  # For formatting purposes

        if user_input == 1:
            translate()
        else:
            close()
            break
    print()  # For formatting purposes

if __name__ == "__main__":
    main()
