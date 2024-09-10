package Day12_SeleniumFramework;

import utilities.ConfigurationReader;

public class DemoConfig {
    public static void main(String[] args) {

        System.out.println(ConfigurationReader.getPropertyValue("baseUrl"));
        System.out.println(ConfigurationReader.getPropertyValue("favoriteFruit"));
        System.out.println(ConfigurationReader.getPropertyValue("phone"));
        System.out.println(ConfigurationReader.getPropertyValue("address"));


    }
}
