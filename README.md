# Your Application Name

This application uses the [Ollama](https://ollama.com) runtime and the [`deepseek-r1:8b`](https://ollama.com/library/deepseek-r1) model (tag: `deepseek-r1:8b`) for advanced code understanding and generation tasks.

## 🚀 Features

- Integration with `deepseek-coder:8b` model via Ollama
- Local inference (no internet connection required after setup)
- Easy installation and usage

---

## 🛠️ Requirements

- Operating System: macOS / Linux / Windows (WSL2 recommended)
- [Ollama](https://ollama.com) installed
- Docker (required for some platforms)
- Git

---

## 📦 Installation Guide

### 1. Install Ollama

Follow the instructions based on your OS from the official website:  
👉 https://ollama.com/download

### 2. Pull the DeepSeek model

After installing Ollama, run the following in your terminal:

```bash
ollama pull deepseek-r1:8b
```

3. Clone this Repository

```bash
git clone https://github.com/bimaaryasatya/AmbaBot.git
cd AmbaBot
```

4. Build the project using Maven:
```
mvn clean install
```
