import sys

def print_translations(translations):
    for t in translations:
        print(f"{t.target_language} Translation:")
        print(t.translated_words[0])

        print()  # Formatting purposes

        print(f"{t.target_language} Example:")
        if t.source_language_sentences and t.target_language_sentences:
            print(f"{t.source_language_sentences[0]}")
            print(f"{t.target_language_sentences[0]}\n")


def write_translations(translations, word_to_translate):
    original_stdout = sys.stdout  # Save reference of the original standard output
    translation_filename = f"{word_to_translate}.txt"
    sys.stdout = open(translation_filename, "w")  # Redirect output to translation file

    print("Epsilon (v2.3)")
    print()  # For formatting purposes

    for t in translations:
        print(f"{t.target_language} Translations:")
        stop = min(5, len(t.translated_words))
        for i in range(0, stop):  # Print at most 5 translated words
            print(t.translated_words[i])

        print()  # Formatting purposes

        print(f"{t.target_language} Examples:")
        stop = min(5, len(t.target_language_sentences))
        for i in range(0, stop):  # Print at most 5 example sentence pairs
            print(f"{t.source_language_sentences[i]}")
            print(f"{t.target_language_sentences[i]}")
            if i < stop - 1:
                print()


    sys.stdout.close()  # Close file
    sys.stdout = original_stdout  # Change standard output back to what it originally was

    print(f"Translation file saved as {translation_filename}")
    print()  # For formatting purposes
