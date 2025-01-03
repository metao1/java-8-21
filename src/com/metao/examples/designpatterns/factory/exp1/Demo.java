package com.metao.examples.designpatterns.factory.exp1;

public class Demo extends WindowsDialog {
    private static Dialog dialog;

    public static void main(String[] args) {
        configure();
        runBusinessLogic();
    }

    /**
     * The concrete factory is usually chosen depending on configuration or
     * environment options.
     */
    static void configure() {
        String osType = System.getProperty("os.name");
        if (osType.equals("Windows 10") || osType.equals("Linux") || osType.equals("Mac OS X") ) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }
    }

    /**
     * All of the client challenges should work with factories and products through
     * abstract interfaces. This way it does not care which factory it works
     * with and what kind of product it returns.
     */
    static void runBusinessLogic() {
        dialog.renderWindow();
    }
}
