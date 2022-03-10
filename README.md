# cs211-641-project

## รายชื่อสมาชิก

- 6210451641 เตชิต เส็งกลิ่น github account name : blind478491
  - เขียนโปรแกรมในส่วน : Controller , Hardcode , GUI
- 6210451306 ปภาวิชญ์ สุวรรณศิริ github account name : paphawits
  - เขียนโปรแกรมในส่วน : service csv
- 6110450855 พิมพ์พิศุทธิ์ พันธ์ทอง github account name : 6110450855
  - เขียนโปรแกรมในส่วน : models ทั้งหมด

## วิธีการติดตั้งหรือรันโปรแกรม
- ใช้คำสั่ง java -jar cs211-431-project-NunNaSi.jar ใน command หรือ double click jar file

## วิธีเริ่มต้นใช้งาน
  - การใช้งาน ***โปรแกรมไม่สามารถป้อนภาษาไทยได้*** เนื่องจากเมื่อใช้ jar file ในการ run จะทำให้เป็นภาษาที่อ่านไม่ได้
  - เมื่อเปิดโปแกรมจะมี หน้าเปิดตู้เย็นจะมีอาหารที่อยู่ในตู้เย็นทั้ง 2 ประเภทคือ Freezer
    และ Chiller โดยแต่ละช่อง จะแสดงข้อมูลที่ใกล้หมดอายุมากที่สุด คือรูปภาพ ชื่ออาหาร จำนวนอาหาร และวันหมดอายุ ของแต่ละช่องแช่นั้น
  - ปุ่ม ผู้จัดทำ จะแสดงข้อมูลของสมาชิก 
  - ปุ่ม วิธีใช้งาน จะแสดงวิธีใช้งานโปรแกรม
    
  - เมื่อทำการเลือกอาหารแล้วระบบจะพาไปยังหน้าจัดการอาหาร ผู้ใช้สามารถ เพิ่มจำนวนอาหาร , ลดจำนวนอาหารและลบอาหาร
    โดยรายการอาหารในช่องนั้น จะเรียงลำดับตามวันหมดอายุ ของอาหาร เมื่อกดปุ่ม ยกเลิก จะกลับไปหน้า mainpage คือ ถ้าช่องแช่ทั้ง 8 ช่อง
    
  - เมื่อเลือก อาหารใน table จะแสดงจำนวนวันที่อยู่ในตู้นเย็น และแสดงรูปภาพ ของอาหารชนิดนั้น
    ถ้าต้องการ เพิ่มหรือลด จำนวนอาหาร ให้เลือกอาหารที่ต้องการจะเพิ่ม แล้วไปแสดงจำนวน ในแก้ไขจำนวนอาหาร (แล้วกด เพิ่ม ถ้าต้องการเพิ่มจำนวนอาหาร) (กด ลด เพื่อลดจำนวนอาหาร)
  - เมื่อต้องการลบอาหารให้กดเลือกอาหารชนิดนั้นแล้วกดปุ่ม ลบอาหาร
    โดยเมื่ออาหารในช่อง หมดอายุ จะถูกลบออกจากช่องนั้น อัตโนมัติ
    
  - เมื่อต้องการเพิ่มอาหารในช่อง ให้เลือก ปุ่ม ไปหน้าเพิ่มอาหาร ในหน้าจัดการอาหาร
    เลือกข้อมูลอาหารที่ต้องการใส่ แล้วกด เพิ่มอาหาร แล้วข้อมูลจะมาแสดงในหน้าจัดการอาหาร

    
## การวางโครงสร้างไฟล์
- directory src/main/java/ku.cs/controllers ใช้เก็บ Class ที่ควบคุมการทำงานของ GUI ของแต่ละหน้า แบ่งเป็น directory ของ addfood, manages และ Class CreatorsController InstructionController MainPageController
- directory src/main/java/ku.cs/models ใช้เก็บ class ที่เป็นข้อมูลสำหรับใช้ในการสร้างโปรแกรม แบ่งเป็น Class ของ Food, FoodList, Refrigerator, RefrigeratorBox, RefrigeratorBoxList
- directory src/main/java/ku.cs/services ใช้เก็บ class ที่ใช้สำหรับการอ่านและเขียนไฟล์หรือตัวช่วยอื่นๆที่ทำให้เกิดความสะดวกในการเขียนโปรแกรม
- directory src/main/resources/ku.cs ใช้เก็บไฟล์ fxml กับรูปภาพ
- directory data ใช้เก็บๆฟล์ csv
- directory project is here ใช้เก็บ jar file ไฟล์ csv รูปภาพ และไฟล์ pdf 


## สรุปสิ่งที่พัฒนาแต่ละครั้งที่นำเสนอความก้าวหน้าของระบบ

- ครั้งที่ 1 (10/01/2022)
  - เพิ่ม models, controllers, ku.cs.services, FXRouter : พิมพ์พิศุทธิ์
  - ทำในส่วน hardcode เพิ่มอาหาร freezer และ chiller , creator page : เตชิต
  - ทำ UI main_page, add_food_page เพิ่มและแก้ไข controllers : ปภาวิชญ์
- ครั้งที่ 2 (02/02/2022)
  - แก้ไข class ใน models เพื่อปรับการรับค่า object : พิมพ์พิศุทธิ์
  - ออกแบบ ui ใหม่ ได้แก่ main_page, manage_food_page, creatorpage ,instruction_page เพิ่มรูปตกแต่ง : เตชิต
  - ทำ List รายการใน MainPageController , ทำการจัดการหน้าเมนูตู้เย็นใน ManageFoodController(แต่ยังเพิ่มอาหารไม่ได้), ทำInstructionController ให้เชื่อมต่อกับ MainPage : ปภาวิชญ์
- ครั้งที่ 3 (23/02/2022)
  - เพิ่ม function เพิ่ม-ลด จำนวนอาหาร, เพิ่มระบบการบันทึกอาหาร, เพิ่มการอัพโหลดภาพจากภายนอก : พิมพ์พิศุทธิ์
  - ทำให้สามารถลบอาหารออกจากช่องแช่ได้หรือ listview และเมื่อออกจากโปรแกรมข้อมูลใน csv ก็จะถูกบันทึกด้วยว่าได้ลบอาหารออกไปแล้ว , Controller , GUI : เตชิต
  - เพิ่ม csv , แก้ไข Datasource, เพิ่ม RefrigertorBoxFileDatasource, เพิ่ม FoodFileDatasource, เพิ่ม StringConfiguration แก้ไข ManageFoodController ให้ ShowTable ใน csv : ปภาวิชญ์
- ครั้งที่ 4 (11/04/2022)
  - แก้ปัญหาการที่ csv ไม่ยอมอ่านแยกตามช่องตู้เย็น โดยการสร้าง controller แยกตามช่อง, แก้ปัญหาการใส่ชื่ออาหารซ้ำ, เพิ่มการเรียงลำดับอาหารตามวันหมดอายุ และการนำอาหารหมดอายุออกโดยอัตโนมัติ : พิมพ์พิศุทธิ์
  - เพิ่มและแก้ไข AddFreezerController , setfoodinfo ใน mainpagecontroller , เพิ่ม Add_Food_Freezer Page , GUI , เพิ่มข้อมูลวิธีใช้งานในinstructionpage : เตชิต
  - เพิ่ม AddChillerController, Edit Foodlist ,เพิ่มข้อมูลในโปรแกรม, เขียนไฟล์ PDF, แก้ services ที่ไม่ได้ใช้, เขียนรายละเอียดการทำงานโปรแกรมใน README  : ปภาวิชญ์
