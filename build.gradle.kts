plugins {
    id ("java")
}

group = "com.veeva"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

repositories {
    mavenCentral()
}

dependencies {

    // Selenium
    testImplementation ("org.seleniumhq.selenium:selenium-java:4.20.0")

    // Cucumber
    testImplementation ("io.cucumber:cucumber-java:7.14.0")
    testImplementation ("io.cucumber:cucumber-testng:7.14.0")

    // TestNG
    testImplementation ("org.testng:testng:7.9.0")

    // Logging
    testImplementation ("org.slf4j:slf4j-api:2.0.9")
    testImplementation ("ch.qos.logback:logback-classic:1.4.11")

    // JSON (test data)
    testImplementation ("com.fasterxml.jackson.core:jackson-databind:2.15.2")

    // Reporting (Extent)
    testImplementation ("com.aventstack:extentreports:5.1.1")
    testImplementation("io.github.bonigarcia:webdrivermanager:5.7.0")

}


tasks.test {
//    useTestNG()
//
//    // VERY IMPORTANT
//    //include("**/*TestRunner.class")
//
//    systemProperty("cucumber.plugin", "pretty")
//    systemProperty("cucumber.glue", "com.veeva.automation")
//    systemProperty("cucumber.features", "src/test/resources/features")
//    systemProperty("cucumber.feature.tags", "@example")
//
//    testLogging {
//        events("passed", "failed", "skipped")
//    }
//
//    failOnNoDiscoveredTests = false
}


tasks.register<JavaExec>("cucumber") {
    group = "verification"
    description = "Run Cucumber Tests"

    classpath = sourceSets["test"].runtimeClasspath
    mainClass.set("io.cucumber.core.cli.Main")

    args = listOf(
        "--plugin", "pretty",
        "--plugin", "html:build/cucumber-report.html",
        "--glue", "com.veeva.automation",
        "src/test/resources/features"
    )
}


