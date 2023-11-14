public class Client {
    public static void main(String[] args) {
        // Sử dụng FileDownloaderProxy để download file mà không cần truyền User-Agent
        Downloader downloader = new FileDownloaderProxy();
        downloader.download("https://example.com/file.zip");
    }
}