package com.metao.examples.designpatterns.dp.adapter.exp3;

public class UsbConnectorAdapterDemo {

    public static void main(String[] args) {
        USB2 usb2Connector = new Usb2Connector();
        usb2Connector.connect();
        USB3 usb3Connector = new Usb3Connector();
        usb3Connector.connect();
        Usb3To2Adapter adapter = new Usb3To2Adapter(usb2Connector);
        adapter.connect();
    }

    interface USB2 {
        void connect();
    }

    interface USB3 {
        void connect();
    }

    static class Usb2Connector implements USB2 {

        @Override
        public void connect() {
            System.out.println("connecting to usb2...");
        }
    }

    static class Usb3Connector implements USB3 {

        @Override
        public void connect() {
            System.out.println("connecting to usb3...");
        }
    }

    static class Usb3To2Adapter implements USB3 {

        private final USB2 usb2;

        public Usb3To2Adapter(USB2 usb2) {
            this.usb2 = usb2;
        }

        @Override
        public void connect() {
            this.usb2.connect();
        }
    }
}
