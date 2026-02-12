## Letter counter - Nguyễn Sơn Hải

### Requirements

Cách gõ các chữ cái có dấu trong Tiếng Việt bằng các chữ cái latin của kiểu gõ telex như sau: `ă=aw`, `â=aa`, `đ=dd`, `ê=ee`, `ô=oo`, `ơ=ow`, `ư=w`.

Đếm số lượng các chữ cái có dấu Tiếng Việt có thể được tạo thành trong 1 chuỗi chữ cái latin nhập vào từ bàn phím. Chuỗi nhập vào không giới hạn số lượng ký tự, không bao gồm các ký tự đặc biệt và khoảng trắng.

### Example

- Input: `hwfdawhwhcoomddfgwdc`
- Output: `6 (w, aw, w, oo, dd, w)`

### Solution

- Tạo hàm `isValid` để kiểm tra điều kiện cho chuỗi đầu vào theo yêu cầu.
- Sử dụng cấu trúc dữ liệu `Set`: Để lưu trữ các quy ước gõ Telex (`aa`, `aw`, `dd`, `ee`, `oo`, `ow`), tối ưu hóa tốc độ tra cứu (O(1)) và đảm bảo các quy ước là độc nhất.
- Duyệt chuỗi ký tự đầu vào bằng con trỏ index. Tại mỗi vị trí, ưu tiên kiểm tra cặp ký tự (2 ký tự liên tiếp) trước, sau đó mới kiểm tra ký tự đơn.
  > Vì một tổ hợp 2 chữ cái (như `aw`) mang một ý nghĩa hoàn chỉnh hơn là 1 chữ cái đơn lẻ (như `w`). Nếu kiểm tra chữ `w` trước, thì khi gặp chuỗi `aw`, chương trình sẽ đếm chữ `w` là một đơn vị, và bỏ lại chữ `a` làm mất đi chữ `ă` dù chữ này cũng là 1 chữ cái có dấu. Sau mỗi lần kiểm tra, tăng biến đếm `count` lên 1 và trả về kết quả khi duyệt hết chuỗi.
- Khi phát hiện một cặp ký tự khớp với quy ước, con trỏ sẽ nhảy 2 bước (`index += 2`) để tránh việc đếm chồng lấp hoặc đếm sai các ký tự đã được xử lý.
