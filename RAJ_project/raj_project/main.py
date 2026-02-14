# main.py
import os
from google import genai

def main():
    # Set your Gemini API key as an environment variable:
    # Windows CMD:
    #   setx GEMINI_API_KEY "YOUR_API_KEY"
    # macOS/Linux:
    #   export GEMINI_API_KEY="YOUR_API_KEY"

    # Initialize Gemini client
    client = genai.Client()

    # Create a chat session
    chat = client.chats.create(model="gemini-2.5-flash")

    print("AI Chatbot is ready! Type 'quit' to exit.")

    while True:
        user_input = input("\nYou: ")
        if user_input.lower() in ["quit", "exit"]:
            print("Goodbye!")
            break

        try:
            # Send user message to chat session
            response = chat.send_message(user_input)

            # Print the model's reply
            print(f"Gemini: {response.text}")

        except Exception as e:
            print("Error:", e)

if __name__ == "__main__":
    main()
