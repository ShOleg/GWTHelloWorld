package ru.javastudy.gwtApp.server;
/* ShOleg  22.04.2021*/
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HibernateUtil {

    private static SessionFactory sessionFactory = buildSessionFactory();

    protected static SessionFactory buildSessionFactory() {

        List<String> lines = new ArrayList<>();
        Path path = Paths.get("C:\\1\\file.txt");

        try {
            Stream<String> lineStream = Files.lines(path);
            lines = lineStream.collect(Collectors.toList());
        } catch (IOException ignored) {
            System.out.println(ignored.getMessage());
        }

        // по умолчанию
        String driver = "org.postgresql.Driver";
        String url = "jdbc:postgresql://localhost:5432/first_db";
        String user = "postgres";
        String pass = "postgres";

        if (! lines.isEmpty()) {
            for (String str : lines) {
                String key = str.split("=")[0].trim();
                String val = str.split("=")[1].trim();

                if (key.equals("driver")) {
                    driver = val.trim();
                } else if (key.equals("url")) {
                    url = val.trim();
                } else if (key.equals("user")) {
                    user = val.trim();
                } else if (key.equals("pass")) {
                    pass = val.trim();
                }
            }
        }

        Configuration aconf = new Configuration();
        aconf.setProperty("hibernate.show_sql", "true");
        aconf.setProperty("hibernate.format_sql", "true");

        aconf.setProperty("hibernate.connection.driver_class", driver);
        aconf.setProperty("hibernate.connection.username", user);
        aconf.setProperty("hibernate.connection.password", pass);
        aconf.setProperty("hibernate.connection.url", url);

        final ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(aconf.getProperties()).build();
        sessionFactory = aconf.buildSessionFactory(registry);
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
