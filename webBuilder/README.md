# WebBuilder – AI Website Generator

An AI-powered agent that generates complete static websites (HTML, CSS, JS) from a simple text prompt. Built with **Spring Boot 4.1.2** and **Spring AI 2.0**.

## Prerequisites

- **Java 21** or later
- **Maven 3.9+** (or use the included Maven wrapper)
- A **Groq API key** – get one for free at [console.groq.com](https://console.groq.com)

## Setup

### 1. Clone the repository

```bash
git clone <repository-url>
cd webBuilder
```

### 2. Set your API key

The application reads the API key from an environment variable called `key`.

**Windows (PowerShell):**
```powershell
$env:key = "gsk_your_groq_api_key_here"
```

**Windows (CMD):**
```cmd
set key=gsk_your_groq_api_key_here
```

**macOS / Linux:**
```bash
export key=gsk_your_groq_api_key_here
```

### 3. Build and run

Using the Maven wrapper (no Maven installation needed):

**Windows:**
```powershell
.\mvnw.cmd spring-boot:run
```

**macOS / Linux:**
```bash
./mvnw spring-boot:run
```

Or with Maven installed:
```bash
mvn spring-boot:run
```

The application starts on **http://localhost:8080**.

## Usage

Send a POST request describing the website you want:

```bash
curl -X POST http://localhost:8080/webBuilder/build \
  -H "Content-Type: text/plain" \
  -d "Create a portfolio website for a photographer named Alex"
```

The AI agent will generate a complete static website inside the `generated-sites/` directory. Open the generated `index.html` in your browser to view the result.

## Project Structure

```
webBuilder/
├── src/main/java/fde/
│   ├── controller/WebBuilderController.java   # REST endpoint
│   ├── service/WebBuilderService.java         # AI chat logic
│   └── tools/Websitetool.java                 # File tools the AI uses
├── src/main/resources/
│   └── application.properties                 # App configuration
├── generated-sites/                           # Output directory for websites
├── pom.xml
└── mvnw / mvnw.cmd                           # Maven wrapper
```

## Configuration

All settings are in `src/main/resources/application.properties`:

| Property | Description |
|---|---|
| `spring.ai.openai.api-key` | API key (reads from `${key}` env variable) |
| `spring.ai.openai.base-url` | API endpoint (default: Groq) |
| `spring.ai.openai.chat.model` | Model to use (default: `openai/gpt-oss-120b`) |

## Troubleshooting

- **`reasoning_content` error** – Already handled by `spring.ai.openai.chat.replay-reasoning-content=false` in the config.
- **Connection refused** – Make sure port 8080 is free, or add `server.port=9090` to `application.properties`.
- **API key errors** – Verify the `key` environment variable is set in the same terminal session where you run the app.
