from translator import get_translations
from user_input import input_int, input_string
from output import print_translations, write_translations
from textwrap import dedent

def translate():
    source_language_menu = """\
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
        """
    print(dedent(source_language_menu))
    source_number = input_int(1, 13, "Language: ")
    print()  # For formatting purposes

    target_language_menu = """\
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
        """
    print(dedent(target_language_menu))
    target_number = input_int(0, 13, "Language: ")
    print()  # For formatting purposes

    if source_number == target_number:
        print("Source and target languages cannot be the same")
    else:
        word_to_translate = input_string("Word to translate: ")

        print("\nTranslating...\n")

        translations = get_translations(source_number, target_number, word_to_translate)
        if translations:
            print_translations(translations)
            write_translations(translations, word_to_translate)

def close():
    print("Epsilon (v2.3)")
