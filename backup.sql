PGDMP         -            	    w            testDB    11.5    11.5 ,    *           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            +           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            ,           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            -           1262    16393    testDB    DATABASE     �   CREATE DATABASE "testDB" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Belarusian_Belarus.1251' LC_CTYPE = 'Belarusian_Belarus.1251';
    DROP DATABASE "testDB";
             postgres    false            .           0    0    DATABASE "testDB"    COMMENT     ,   COMMENT ON DATABASE "testDB" IS 'first DB';
                  postgres    false    2861            �            1259    18024    Comments    TABLE     �   CREATE TABLE public."Comments" (
    comment_id integer NOT NULL,
    news_id integer NOT NULL,
    author_id integer NOT NULL,
    comment_text text NOT NULL,
    sending_date date NOT NULL
);
    DROP TABLE public."Comments";
       public         postgres    false            �            1259    18037    Comments_author_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Comments_author_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public."Comments_author_id_seq";
       public       postgres    false    204            /           0    0    Comments_author_id_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public."Comments_author_id_seq" OWNED BY public."Comments".author_id;
            public       postgres    false    205            �            1259    18020    Comments_comment_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Comments_comment_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public."Comments_comment_id_seq";
       public       postgres    false    204            0           0    0    Comments_comment_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public."Comments_comment_id_seq" OWNED BY public."Comments".comment_id;
            public       postgres    false    202            �            1259    18022    Comments_news_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Comments_news_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public."Comments_news_id_seq";
       public       postgres    false    204            1           0    0    Comments_news_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public."Comments_news_id_seq" OWNED BY public."Comments".news_id;
            public       postgres    false    203            �            1259    17687    News    TABLE     �   CREATE TABLE public."News" (
    news_id integer NOT NULL,
    author_id integer NOT NULL,
    tittle character(100) NOT NULL,
    news_text text NOT NULL,
    public_date date NOT NULL
);
    DROP TABLE public."News";
       public         postgres    false            �            1259    17685    News_news_id_seq    SEQUENCE     �   CREATE SEQUENCE public."News_news_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public."News_news_id_seq";
       public       postgres    false    199            2           0    0    News_news_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public."News_news_id_seq" OWNED BY public."News".news_id;
            public       postgres    false    198            �            1259    17699    Tags    TABLE     X   CREATE TABLE public."Tags" (
    "news_ID" integer NOT NULL,
    tags character(100)
);
    DROP TABLE public."Tags";
       public         postgres    false            �            1259    18001    Tags_news_ID_seq    SEQUENCE     �   CREATE SEQUENCE public."Tags_news_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public."Tags_news_ID_seq";
       public       postgres    false    200            3           0    0    Tags_news_ID_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public."Tags_news_ID_seq" OWNED BY public."Tags"."news_ID";
            public       postgres    false    201            �            1259    17671    Users    TABLE       CREATE TABLE public."Users" (
    user_id integer NOT NULL,
    login character(100) NOT NULL,
    hash_password character(100) NOT NULL,
    user_name character(100) NOT NULL,
    user_last_name character(100) NOT NULL,
    date_of_registration date NOT NULL
);
    DROP TABLE public."Users";
       public         postgres    false            �            1259    17669    Users_user_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Users_user_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public."Users_user_id_seq";
       public       postgres    false    197            4           0    0    Users_user_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public."Users_user_id_seq" OWNED BY public."Users".user_id;
            public       postgres    false    196            �
           2604    18027    Comments comment_id    DEFAULT     ~   ALTER TABLE ONLY public."Comments" ALTER COLUMN comment_id SET DEFAULT nextval('public."Comments_comment_id_seq"'::regclass);
 D   ALTER TABLE public."Comments" ALTER COLUMN comment_id DROP DEFAULT;
       public       postgres    false    204    202    204            �
           2604    18028    Comments news_id    DEFAULT     x   ALTER TABLE ONLY public."Comments" ALTER COLUMN news_id SET DEFAULT nextval('public."Comments_news_id_seq"'::regclass);
 A   ALTER TABLE public."Comments" ALTER COLUMN news_id DROP DEFAULT;
       public       postgres    false    203    204    204            �
           2604    18039    Comments author_id    DEFAULT     |   ALTER TABLE ONLY public."Comments" ALTER COLUMN author_id SET DEFAULT nextval('public."Comments_author_id_seq"'::regclass);
 C   ALTER TABLE public."Comments" ALTER COLUMN author_id DROP DEFAULT;
       public       postgres    false    205    204            �
           2604    17690    News news_id    DEFAULT     p   ALTER TABLE ONLY public."News" ALTER COLUMN news_id SET DEFAULT nextval('public."News_news_id_seq"'::regclass);
 =   ALTER TABLE public."News" ALTER COLUMN news_id DROP DEFAULT;
       public       postgres    false    199    198    199            �
           2604    18003    Tags news_ID    DEFAULT     r   ALTER TABLE ONLY public."Tags" ALTER COLUMN "news_ID" SET DEFAULT nextval('public."Tags_news_ID_seq"'::regclass);
 ?   ALTER TABLE public."Tags" ALTER COLUMN "news_ID" DROP DEFAULT;
       public       postgres    false    201    200            �
           2604    17674    Users user_id    DEFAULT     r   ALTER TABLE ONLY public."Users" ALTER COLUMN user_id SET DEFAULT nextval('public."Users_user_id_seq"'::regclass);
 >   ALTER TABLE public."Users" ALTER COLUMN user_id DROP DEFAULT;
       public       postgres    false    197    196    197            &          0    18024    Comments 
   TABLE DATA               `   COPY public."Comments" (comment_id, news_id, author_id, comment_text, sending_date) FROM stdin;
    public       postgres    false    204   �/       !          0    17687    News 
   TABLE DATA               T   COPY public."News" (news_id, author_id, tittle, news_text, public_date) FROM stdin;
    public       postgres    false    199   0       "          0    17699    Tags 
   TABLE DATA               1   COPY public."Tags" ("news_ID", tags) FROM stdin;
    public       postgres    false    200   �0                 0    17671    Users 
   TABLE DATA               q   COPY public."Users" (user_id, login, hash_password, user_name, user_last_name, date_of_registration) FROM stdin;
    public       postgres    false    197   )1       5           0    0    Comments_author_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public."Comments_author_id_seq"', 1, false);
            public       postgres    false    205            6           0    0    Comments_comment_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public."Comments_comment_id_seq"', 3, true);
            public       postgres    false    202            7           0    0    Comments_news_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public."Comments_news_id_seq"', 1, false);
            public       postgres    false    203            8           0    0    News_news_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public."News_news_id_seq"', 2, true);
            public       postgres    false    198            9           0    0    Tags_news_ID_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public."Tags_news_ID_seq"', 1, false);
            public       postgres    false    201            :           0    0    Users_user_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public."Users_user_id_seq"', 2, true);
            public       postgres    false    196            �
           2606    18030    Comments Comments_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public."Comments"
    ADD CONSTRAINT "Comments_pkey" PRIMARY KEY (comment_id);
 D   ALTER TABLE ONLY public."Comments" DROP CONSTRAINT "Comments_pkey";
       public         postgres    false    204            �
           2606    17676    Users Users_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public."Users"
    ADD CONSTRAINT "Users_pkey" PRIMARY KEY (user_id);
 >   ALTER TABLE ONLY public."Users" DROP CONSTRAINT "Users_pkey";
       public         postgres    false    197            �
           2606    18008    News primary 
   CONSTRAINT     S   ALTER TABLE ONLY public."News"
    ADD CONSTRAINT "primary" PRIMARY KEY (news_id);
 :   ALTER TABLE ONLY public."News" DROP CONSTRAINT "primary";
       public         postgres    false    199            �
           2606    18009    Tags NewsKEy    FK CONSTRAINT     �   ALTER TABLE ONLY public."Tags"
    ADD CONSTRAINT "NewsKEy" FOREIGN KEY ("news_ID") REFERENCES public."News"(news_id) NOT VALID;
 :   ALTER TABLE ONLY public."Tags" DROP CONSTRAINT "NewsKEy";
       public       postgres    false    2718    200    199            �
           2606    17694    News News_author_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."News"
    ADD CONSTRAINT "News_author_id_fkey" FOREIGN KEY (author_id) REFERENCES public."Users"(user_id);
 F   ALTER TABLE ONLY public."News" DROP CONSTRAINT "News_author_id_fkey";
       public       postgres    false    199    2716    197            �
           2606    18047    Comments author_id    FK CONSTRAINT     �   ALTER TABLE ONLY public."Comments"
    ADD CONSTRAINT author_id FOREIGN KEY (author_id) REFERENCES public."Users"(user_id) NOT VALID;
 >   ALTER TABLE ONLY public."Comments" DROP CONSTRAINT author_id;
       public       postgres    false    204    197    2716            �
           2606    18031    Comments news_id    FK CONSTRAINT     w   ALTER TABLE ONLY public."Comments"
    ADD CONSTRAINT news_id FOREIGN KEY (news_id) REFERENCES public."News"(news_id);
 <   ALTER TABLE ONLY public."Comments" DROP CONSTRAINT news_id;
       public       postgres    false    2718    204    199            &   e   x�3�4�4⼰�bӅ}
[.�^إ�p���L�id``�F\F� xa�}6]��za��h�V����t=��}�/6+\�4��/v#������ �"C      !   �   x���1�0E��� ��y8L�T��������r��a)c�(�����Ҕ�;H\�G�;>":�Rt�7&������B����W#�﹑��RM��f5���*�r3o[iē̟0*�*j$����DB��UKs������c��Zk?U��Y      "   J   x�3��paÅ��]�xa���/l���[h��8��Z��b��nZY�hIЏ;.졹e1z\\\ �"G         O   x�3��uVp��S�!�4426��`K@���%.�~�����4�����P���@���6�%�h��G�W� .�p�     