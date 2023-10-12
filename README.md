# File-Hashsum-Generator

The **File Hashsum Generator** is a Java program that generates SHA3-256 hash values for files using multi-threading for improved performance. The Bouncy Castle library is utilized to encode the hash generated after applying the SHA3-256 algorithm.

## Features

- Efficiently generates SHA3-256 hash values for one or multiple files.
- Utilizes multi-threading for parallel processing, optimizing the hash generation process.
- Uses the Bouncy Castle library for secure encoding of hash values.
- Works on various platforms, as it is implemented in Java.

## Usage

### Prerequisites

- Java Runtime Environment (JRE)
- Bouncy Castle library (bcprov-jdk15on-xxx.jar)
- [Download Bouncy Castle](https://www.bouncycastle.org/latest_releases.html)

### Running the Program

1. Ensure that you have the Java Runtime Environment (JRE) installed.
2. Download the Bouncy Castle library and place the JAR file (e.g., bcprov-jdk15on-xxx.jar) in the same directory as your File Hashsum Generator JAR file.
3. Open a terminal or command prompt.

To generate hash values for files, use the following command:

```bash
java -cp "FileHashsumGenerator.jar:bcprov-jdk15on-xxx.jar" FileHashsumGenerator <file_path_1> <file_path_2> ...
