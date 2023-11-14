class FileDownloader implements Downloader {
    private String userAgent;

    public FileDownloader(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public void download(String url) {
        // Triển khai logic download file từ URL sử dụng User-Agent
        System.out.println("Downloading file from " + url + " with User-Agent: " + userAgent);
        // ... (Đoạn mã thực tế của quá trình download)
        System.out.println("Download complete!");
    }
}