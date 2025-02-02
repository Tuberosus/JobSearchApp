# Приложение для поиска вакансий

Небольшое приложение для поиска работы, использующее [API сервиса HeadHunter](https://github.com/hhru/api). Приложение предоставляет следующую функциональность:

- Поиск вакансий;
- Указание фильтров для поиска;
- Просмотр деталей отдельной вакансии;
- И добавление вакансий в список "Избранного".

## Общие сведения

- Приложение поддерживает устройства, начфиная с Android 8.0 (minSdkVersion = 26)
- Приложение поддерживает только портретную ориентацию (`portrait`), при перевороте экрана ориентация не меняется.

## Особенностей различных экранов приложения.

### Главный экран -- экран поиска вакансий

На этом экране пользователь может искать вакансии по любому непустому набору слов поискового запроса. Результаты поиска
представляют собой список, содержащий краткую информацию о вакансиях.

### Особенности экрана и взаимодействия
1. Кнопка перехода на экран фильтров (фильтры неактивны)
2. Строка для поискового запроса
3. Изображение-заглушка
4. BottomNavigation с разделами приложения

![SearchScreenEdited](https://github.com/user-attachments/assets/a34562a3-64a0-489d-98d1-d7d900b3a0af)


- По умолчанию, поиск происходит по всей доступной базе вакансий без учёта региона, отрасли компании и уровня зарплаты и валюты.
- При вводе нового текста в поле ввода новый запрос будет осуществлён с задержкой в 2000 миллисекунд.
- В отдельном элементе списка может быть картинка логотипа компании, которую нужно дополнительно загрузить. В процессе
  загрузки картинки и в случае ошибки загрузки этой картинки будет показан плейсхолдер. Также плейсхолдер отображается,
  если информации о картинке нет.
- Если в вакансии указана зарплата, то она будет указана в формате "от/от-до/до"
- Зарплата в вакансии может быть указана в разной валюте, не только в рублях.
- Загрузка результатов поиска происходит постранично (paging) по 20
  элементов за раз. Запрос на следующую страницу происходит, когда пользователь доскроллил до последнего
  доступного элемента списка.

### Экран поиска вакансий с результатами

1. Фильтры (активны)
2. Количество найденных вакансий, подходящих по запросу
3. Список вакансий
4. Элемент списка (вакансия) - при нажатии открывается детальная информация о ней

![SearchResultScreenEdited](https://github.com/user-attachments/assets/920871dc-8c60-4a34-bbb2-13273cf47a5e)

## Фильтрация - набор экранов фильтров поиска

1. Выбор региона и города/области поиска
2. Выбор отрасли
3. При вводе ожидаемой ЗП первыми в списке будут вакансии наиболее близкие к ней
4. Чекбокс - показывать ли вакансии без зарплаты или нет
5. Применение фильтров
6. Сброс всех фильтров

![FilterScreenEdited](https://github.com/user-attachments/assets/081b0ac0-13de-4cee-920b-fa5bea7423b2)

Пользователь может использовать настройки фильтра, чтобы уточнить некоторые параметры поиска, который осуществляется на экране
"Поиск". Фильтр позволяет указать:

- Место работы - регион, населённый пункт, указанный в вакансии как рабочая локация.
- Отрасль - сфера деятельности организации, разместившей вакансию.
- Уровень зарплаты - уровень ЗП, соответствующий указанному в вакансии.
- Возможность скрывать вакансии, для которых не указана ЗП.

### Особенности фильтрации:

- Пользователь может уточнить любой параметр из предложенных, а может не указывать ничего. В случае, если указан хотя бы один из параметров он будет учитываться при всех последующих поисковых
  запросах на экране "Поиск".
- Настройки параметров фильтра сохраняются даже после закрытия приложения.
- Поиск по отраслям компании ведётся сразу по всем элементам дерева отраслей, без разделения на категории по уровнямвложенности.
- Экраны фильтрации отображаются поверх нижней навигации.
- Если у пользователя выбрана страна поиска вакансий, то список регионов на экране выбора региона поиска ограничивается регионами указанной страны.
- Если пользователь выбрал город до выбора страны, то страна подставится автоматически.
- Кнопка "Сбросить" появляется, если указано хотя бы одно значение фильтров.
- Нажатие на кнопку «Применить» на экране фильтра возвращает пользователя на экран поиска. И если поле ввода поискового
  запроса было не пустым, то этот поисковый запрос автоматически выполнится с применением актуальныхнастроек фильтрации.
- Все настройки фильтра сохраняются автоматически сразу после изменения.

## Экран просмотра деталей вакансии

1. Поделиться ссылкой на вакансию
2. Добавить вакансию в избранное (неактивное состояние)
3. Название вакансии
4. Вилка заработной платы
5. Логотип, название, город работодателя
6. Требования к опыту и тип занятости
7. Блок с детальным описанием вакансии

![VacancyDetailsEdited](https://github.com/user-attachments/assets/d0d85bec-a29d-4875-836d-00fc1c220efa)

Нажав на элемент списка найденных вакансий (аналогично в списке избранного), пользователь попадает на
экран с подробным описанием вакансии. Помимо уровня ЗП, требуемого опыта и графика работы на этом экране можно увидеть:

- Информацию о работодателе
- Подробное описание вакансии
- Перечень требуемых ключевых навыков

Также пользователь может поделиться ссылкой на данную вакансию.

### Особенности экрана деталей:

- Программа отображает те данные, которые указаны в вакансии, если в детальном описании отсутствует описание ключевых навыков - значит они не указаны в самой вакансии на hh.ru.
- Экран деталей вакансии отображаются поверх нижней навигации.
- Запрос на детали вакансии может вернуть 404, если вакансию удалили на сервере

## Экран избранных вакансий

Пользователь может добавлять вакансии в "Избранное", чтобы иметь возможность быстро вернуться к заинтересовавшему его
предложению. Добавить вакансию в "избранное" (или удалить из "избранного") можно на экране "Вакансия". Все вакансии,
добавленные в закладки, можно увидеть на отдельном экране в приложении.

### Особенности экрана:

- Вакансии, добавленные в "избранное" можно просматривать без подключения к интернету. Если нет интернета, вместо
  логотипа компании можно показывать плейсхолдер.
- Если пользователь добавляет вакансию в закладки, она должна сразу появиться на экране списка закладок.

## Экран информации о команде разработчиков

На экране отображается статический список людей, участвовавших в разработке приложения. 
