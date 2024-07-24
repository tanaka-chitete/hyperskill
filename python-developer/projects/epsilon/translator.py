import requests
from bs4 import BeautifulSoup
from translation import Translation


languages = [
    "Arabic",
    "Dutch",
    "English",
    "French",
    "German",
    "Hebrew",
    "Japanese",
    "Polish",
    "Portuguese",
    "Romanian",
    "Russian",
    "Spanish",
    "Turkish"
]


def get_translations(source_number, target_number, word_to_translate):
    source_index = source_number - 1  # Convert to zero-based index
    if target_number == 0:
        start_target_index = 0
        end_target_index = len(languages)
    else:
        start_target_index = target_number - 1  # Convert to zero-based index
        end_target_index = target_number

    translations = list()
    source_language = languages[source_index]
    session = requests.Session()  # Create session to speed up get requests
    for i in range(start_target_index, end_target_index):
        if i != source_index:  # Prevent translating to the same language
            try:
                # Convert short form languages to their long-form equivalents
                target_language = languages[i]

                # Retrieve the page
                url = f"https://context.reverso.net/translation/{source_language.lower()}-{target_language.lower()}/{word_to_translate}"
                headers = {'User-Agent': 'Mozilla/5.0'}
                response = session.get(url, headers=headers)

                response.raise_for_status()  # Raises HTTPError, if one occurs

                # Attempt to parse response
                if response.status_code == 200:
                    translations.append(parse_response(source_language, target_language, response))
            except requests.ConnectionError:
                print(f"Unable to establish connection\n")
            except requests.HTTPError:
                print(f"Unable to translate '{word_to_translate}' from {source_language} to {target_language}\n")

    return translations


def parse_response(source_language, target_language, response):
    translated_words = list()
    source_language_sentences = list()
    target_language_sentences = list()

    soup = BeautifulSoup(response.content, "html.parser")

    for a in soup.find_all("a", {"class": ["translation", "ltr", "dict"]}):
        if a.text.strip():
            translated_words.append(a.text.strip())
    translated_words = translated_words[1:]  # Remove unnecessary "Translation" string from the beginning of the list

    for div in soup.find_all("div", {"class": "src"}):
        if div.text.strip():
            source_language_sentences.append(div.text.strip())

    for div in soup.find_all("div", {"class": "trg"}):
        if div.text.strip():
            target_language_sentences.append(div.text.strip())

    return Translation(source_language,
                       target_language,
                       translated_words,
                       source_language_sentences,
                       target_language_sentences)
