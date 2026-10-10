package MixedProjects;

public class SimulationManager {
    public void kinematicSimulationWithoutFriction(float initialSpeed){
        float gravityAcceleration = -9.8f;

        float speed = initialSpeed;
        float height = 0f;
        float deltaTime = 0.01f; // If we want to see the closest real speed value, we can decrease this value.
        float currentTime = 0f;
        boolean isMaxHeightReached = false;

        System.out.println("-----------SÜRTÜNMESİZ ORTAM------------");
        System.out.println("Başlangıç Hızı: " + initialSpeed);
        System.out.println("Başlangıç Yüksekliği: " + height);
        System.out.println("Başlangıç Zamanı: " + currentTime);
        System.out.println("Yerçekimi İvmesi: " + gravityAcceleration);
        System.out.println("----------------------------------------");

        while (height >= 0){
            speed = speed + (gravityAcceleration * deltaTime);
            height = height + (speed * deltaTime);
            currentTime = currentTime + deltaTime;

            if (speed <= 0 && !isMaxHeightReached){
                System.out.println("Maksimum Yükseklik: " + height);
                System.out.println("Maksimum Yüksekliğe Ulaşana Kadar Geçen Zaman: " + currentTime);
                isMaxHeightReached = true;
            }

            if (height <= 0 && speed < 0){
                System.out.println("----------------------------------------");
                System.out.println("Yere Çarpma Hızı: " + speed);
                System.out.println("Yere Çarpana Kadar Geçen Zaman: " + currentTime);
            }
        }
        System.out.println("----------------------------------------");
    }

    public void kinematicSimulationWithFriction(float initialSpeed){
        float gravityAcceleration = -9.8f;

        float dragCoefficient = 0.002f;

        float speed = initialSpeed;
        float height = 0f;
        float deltaTime = 0.01f; // If we want to see the closest real speed value, we can decrease this value.
        float currentTime = 0f;
        boolean isMaxHeightReached = false;

        System.out.println("------------SÜRTÜNMELİ ORTAM------------");
        System.out.println("Başlangıç Hızı: " + initialSpeed);
        System.out.println("Başlangıç Yüksekliği: " + height);
        System.out.println("Başlangıç Zamanı: " + currentTime);
        System.out.println("Yerçekimi İvmesi: " + gravityAcceleration);
        System.out.println("Hava Direnci Katsayısı: " + dragCoefficient);
        System.out.println("----------------------------------------");

        while (height >= 0){
            float dragAcceleration = -dragCoefficient * speed * Math.abs(speed);
            float totalAcceleration = gravityAcceleration + dragAcceleration;

            speed = speed + (totalAcceleration * deltaTime);
            height = height + (speed * deltaTime);
            currentTime = currentTime + deltaTime;

            if (speed <= 0 && !isMaxHeightReached){
                System.out.println("Maksimum Yükseklik: " + height);
                System.out.println("Maksimum Yüksekliğe Ulaşana Kadar Geçen Zaman: " + currentTime);
                isMaxHeightReached = true;
            }

            if (height <= 0 && speed < 0){
                System.out.println("----------------------------------------");
                System.out.println("Yere Çarpma Hızı: " + speed);
                System.out.println("Yere Çarpana Kadar Geçen Zaman: " + currentTime);
            }
        }

        System.out.println("----------------------------------------");

        float limitSpeed = (float) Math.sqrt((Math.abs(gravityAcceleration) / dragCoefficient));
        System.out.println("Limit Hız: " + limitSpeed);

        System.out.println("----------------------------------------");
    }
}
