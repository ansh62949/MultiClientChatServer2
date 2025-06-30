# MultiClientChatServer2

A simple multithreaded chat server built in Java.

## 🚀 Features
- Supports multiple clients using Java threads
- Real-time group messaging
- Easy to extend with usernames or commands

## 🛠️ How to Run

### 1. Compile the code
```bash
javac -d out src/com/chatserver/*.java###  2. Start the server
2. Start the Server
bash
Copy
Edit
java -cp out com.chatserver.Server
3. Connect Clients
Open another terminal (or multiple) and use:

bash
Copy
Edit
telnet localhost 12345
4. Chat!
Type messages in one terminal, and they’ll appear in all others.

📁 Project Structure
pgsql
Copy
Edit
MultiClientChatServer2/
├── src/
│   └── com/
│       └── chatserver/
│           ├── Server.java
│           └── ClientHandler.java
├── out/
├── .idea/
├── .gitignore
├── README.md
└── LICENSE




