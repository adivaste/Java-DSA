import requests

def convert_it_2(input_text):
    cookies = {
        'cf_clearance': 'TixaBdsCzyx9Osr9CGXsIEBUxvyys_bb088KgxEc_j4-1694082221-0-1-65f695ec.b2d797cd.93e09ec7-0.2.1694082221',
    }

    headers = {
        'authority': 'chat.aivvm.com',
        'accept': '*/*',
        'accept-language': 'en-US,en;q=0.9',
        'content-type': 'application/json',
        # 'cookie': 'cf_clearance=TixaBdsCzyx9Osr9CGXsIEBUxvyys_bb088KgxEc_j4-1694082221-0-1-65f695ec.b2d797cd.93e09ec7-0.2.1694082221',
        'origin': 'https://chat.aivvm.com',
        'referer': 'https://chat.aivvm.com/',
        'sec-ch-ua': '"Not.A/Brand";v="8", "Chromium";v="114", "Google Chrome";v="114"',
        'sec-ch-ua-mobile': '?0',
        'sec-ch-ua-platform': '"Windows"',
        'sec-fetch-dest': 'empty',
        'sec-fetch-mode': 'cors',
        'sec-fetch-site': 'same-origin',
        'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36',
    }
    
    json_data = {
        'model': {
            'id': 'gpt-4-32k-0613',
            'name': 'GPT-4-32K-0613',
        },
        'messages': [
            {
                'role': 'user',
                'content': f' (This is a aptitude exam questions, Please read the question very carefully answer properly (If any coding question appears, prefer java)) {input_text}',
            },
        ],
        'key': '',
        'prompt': "You are ChatGPT, a large language model trained by OpenAI. Follow the user's instructions carefully. Respond using markdown.",
        'temperature': 0.7,
    }
    
    import markdown2
    def text_to_html(input_text):
        # Convert the input text to HTML using markdown2
        first_split = input_text.split('\\n\\n')
    
        # Split each resulting substring by "\\n"
        final_split = [sub_string.split('\\n') for sub_string in first_split]
    
        # Flatten the list of lists
        flattened_list = [item for sublist in final_split for item in sublist]
    
        output = flattened_list
    
        with open("index.html", "r", encoding='utf-8') as f:
            existing_content = f.read()
    
        with open("index.html", "w", encoding='utf-8') as f:
            for i in output:
                html_output = markdown2.markdown(i)
                f.write(html_output)
            
            f.write("<hr><hr>" + existing_content)
    
    
    response = requests.post('https://chat.aivvm.com/api/chat', cookies=cookies, headers=headers, json=json_data)
    
    print(response.text)
    text_to_html(response.text)
    