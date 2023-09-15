import os
import time
from time import sleep
import requests
import re
import markdown2
from watchdog.observers import Observer
from watchdog.events import FileSystemEventHandler
from other import convert_it_2

def text_to_html(input_text):
    # Convert the input text to HTML using markdown2
    first_split = input_text.split('\\n\\n')

    # Split each resulting substring by "\\n"
    final_split = [sub_string.split('\\n') for sub_string in first_split]

    # Flatten the list of lists
    flattened_list = [item for sublist in final_split for item in sublist]

    output = flattened_list

    with open("index.html", "r") as f:
        existing_content = f.read()

    with open("index.html", "w") as f:
        for i in output:
            html_output = markdown2.markdown(i)
            f.write(html_output)
        
        f.write("<hr><hr>" + existing_content)

        

def extract_assistant_response(chunk):
    # Find the index of the assistant's response within the chunk
    start_index = chunk.find('"content":"') + len('"content":"')
    end_index = chunk.find('"', start_index)

    if start_index >= 0 and end_index >= 0:
        assistant_response = chunk[start_index:end_index]
        return assistant_response

    return ""

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

    # Process the assistant's response and generate HTML
    text_to_html(finalcodetext)
    print(":: Done !!!")

class QueryHandler(FileSystemEventHandler):
    def on_created(self, event):
        if event.is_directory:
            return

        # Process the newly created file
        time.sleep(2)
        if event.src_path.endswith(".txt"):
            # Process the newly created .txt file
            time.sleep(2)
            with open(event.src_path, "r") as query_file:
                query_text = query_file.read()
                updated_query_text = "(This is an aptitude exam question. Please read the question carefully and answer properly. For code questions, prefer Java.) " + query_text
                print(":: Processing ==> " + query_text)
                # make_api_request(updated_query_text)
                convert_it_2(query_text)
        else:
            print(f"Ignored non-txt file: {event.src_path}")

            

        # Optionally, delete the processed file
        # sleep(2)
        # os.remove(event.src_path)

if __name__ == "__main__":
    # Replace with the path to the folder where new files will arrive
    queries_folder = r'C:\Users\Admin\Downloads\SideKick-Downloads'
    queries_folder = r'C:\Users\Admin\Downloads'


    event_handler = QueryHandler()
    observer = Observer()
    observer.schedule(event_handler, path=queries_folder, recursive=False)
    observer.start()

    try:
        while True:
            time.sleep(5)  # Adjust the interval as needed
    except KeyboardInterrupt:
        observer.stop()
    observer.join()
