# Architecture

Sensor Simulator → BlockingQueue → Worker Threads → Database → REST API

## Design
- Producer–Consumer pattern
- Multithreaded processing
- Thread-safe queue communication
