# Doppler Java Client

A Java client library for interacting with the Doppler API. This library allows you to manage projects, environments, configs, tokens, and secrets in Doppler from your Java applications.

## Features
- Authenticate with Doppler using API tokens
- List and manage projects, environments, configs, and tokens
- Retrieve secrets for a given config
- Simple, object-oriented API

## Installation

Add the following dependencies to your Maven `pom.xml`:

```xml
<dependency>
    <groupId>com.squareup.okhttp3</groupId>
    <artifactId>okhttp</artifactId>
    <version>4.9.3</version>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.13.3</version>
</dependency>
```

Clone this repository and include the source files in your project if needed.

## Usage

```java
import ngo.nabarun.doppler.api.ConfigsApi;

ConfigsApi configsApi = new ConfigsApi("your_project", "your_token");
Config[] configs = configsApi.listConfigs();
List<Secret> secrets = configsApi.getSecrets("config_name");
```

## API Reference

- `DopplerClient`: Handles HTTP requests and authentication.
- `BaseApi`: Base class for API modules.
- `ConfigsApi`: List configs and retrieve secrets.
- Other modules: `ProjectsApi`, `EnvironmentsApi`, `TokensApi` (see source files for details).

## Contributing

Contributions are welcome! Please open issues or submit pull requests.

## License

This project is licensed under the MIT License.

## Contact

For questions or support, contact the maintainer at [ngonabarun.itmanager@gmail.com].

