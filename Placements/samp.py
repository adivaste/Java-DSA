import requests
import re

import markdown2

def text_to_html(input_text):
    # Convert the input text to HTML using markdown2
    first_split = input_text.split('\\n\\n')

    # Split each resulting substring by "\\n"
    final_split = [sub_string.split('\\n') for sub_string in first_split]

    # Flatten the list of lists
    flattened_list = [item for sublist in final_split for item in sublist]

    output = flattened_list
    print(output)

    with open("index.html" , "w") as f:
        for i in output:
            html_output = markdown2.markdown(i)
            f.write(html_output)

def extract_assistant_response(chunk):
    # Find the index of the assistant's response within the chunk
    start_index = chunk.find('"content":"') + len('"content":"')
    end_index = chunk.find('"', start_index)
    
    if start_index >= 0 and end_index >= 0:
        assistant_response = chunk[start_index:end_index]
        return assistant_response
    
    return ""

def print_pretty_response(response):
    # Remove unnecessary line breaks and print the response
    response = re.sub(r'\n+', '\n', response)  # Remove extra line breaks
    response = response.strip()  # Remove leading and trailing spaces
    response.split("\n")
    print(response)


def make_api_request(text):
    api_url = 'https://api.ylokh.xyz/v1/chat/completions'

    headers = {
        'authority': 'api.ylokh.xyz',
        'accept': '*/*',
        'accept-language': 'en-US,en;q=0.9',
        'content-type': 'application/json',
        'origin': 'https://chat.ylokh.xyz',
        'referer': 'https://chat.ylokh.xyz/',
        'sec-ch-ua': '"Not.A/Brand";v="8", "Chromium";v="114", "Google Chrome";v="114"',
        'sec-ch-ua-mobile': '?0',
        'sec-ch-ua-platform': 'Windows',
        'sec-fetch-dest': 'empty',
        'sec-fetch-mode': 'cors',
        'sec-fetch-site': 'same-site',
        'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36'
    }

    data = {
        "messages": [{"role": "user", "content": text}],
        "model": "gpt-3.5-turbo-16k",
        "temperature": 1,
        "presence_penalty": 0,
        "top_p": 1,
        "frequency_penalty": 0,
        "allow_fallback": True,
        "stream": True
    }

    response = requests.post(api_url, headers=headers, json=data, stream=True)

    finalcodetext = ""
    if response.status_code == 200:
        for chunk in response.iter_lines(decode_unicode=True):
            if chunk:
                assistant_response = extract_assistant_response(chunk)
                
                if assistant_response is not None:
                    finalcodetext = finalcodetext + assistant_response
    else:
        print(f"API request failed with status code: {response.status_code}")

    print(finalcodetext)
    res = text_to_html(finalcodetext)
    

def main():
    try:
        # Replace this with your text selection logic, or you can read from a file
        selected_text = input("Enter the text you want to process: ")
        selected_text = "(Do as per instructed properly) " + selected_text
        # Make the API request
        make_api_request(selected_text)
    except Exception as e:
        print(f"Error: {e}")

if __name__ == "__main__":
    main()
